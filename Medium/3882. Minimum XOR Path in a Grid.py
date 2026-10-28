class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        R, C = len(grid), len(grid[0])
        dp = [set() for _ in range(C)]
        dp[0].add(grid[0][0])
        for r in range(R):
            for c in range(C):
                if r == 0 and c == 0:
                    continue
                val = grid[r][c]
                reachable = dp[c] | (dp[c - 1] if c > 0 else set())
                dp[c] = {k ^ val for k in reachable}
        return min(dp[-1])
