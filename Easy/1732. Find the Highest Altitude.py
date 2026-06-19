class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        curr = maxx = 0
        for diff in gain:
            curr += diff
            maxx = max(curr, maxx)
        return maxx
