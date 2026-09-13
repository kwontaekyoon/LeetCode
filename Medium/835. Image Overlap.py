class Solution:
    def largestOverlap(self, img1, img2):
        n = len(img1)
        ones1 = [(r, c) for r in range(n) for c in range(n) if img1[r][c] == 1]
        ones2 = [(r, c) for r in range(n) for c in range(n) if img2[r][c] == 1]
        frequency = defaultdict(int)
        maxOverlap = 0
        for r1, c1 in ones1:
            for r2, c2 in ones2:
                key = (r1 - r2, c1 - c2)
                frequency[key] += 1
                maxOverlap = max(maxOverlap, frequency[key])
        return maxOverlap