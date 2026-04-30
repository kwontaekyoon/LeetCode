class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        rows, cols = len(grid), len(grid[0])
        NEG = -10 ** 9
        prev = [[NEG] * (k + 1) for _ in range(cols)]
        for r in range(rows):
            curr = [[NEG] * (k + 1) for _ in range(cols)]
            for c in range(cols):
                gain = grid[r][c]
                cost = 0 if not gain else 1
                limit = min(k, r + c)
                if r == 0 and c == 0:
                    curr[0][0] = 0
                    continue
                for l in range(cost, limit + 1):
                    best = NEG
                    if r > 0 and prev[c][l - cost] != NEG:
                        best = max(prev[c][l - cost] + gain, best)
                    if c > 0 and curr[c - 1][l - cost] != NEG:
                        best = max(curr[c - 1][l - cost] + gain, best)
                    curr[c][l] = best
            prev = curr
        max_score = max(prev[cols - 1])
        return -1 if max_score < 0 else max_score
