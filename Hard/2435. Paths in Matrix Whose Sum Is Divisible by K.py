from typing import List


class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[[0 for _ in range(k)] for _ in range(n)] for _ in range(m)]
        dp[0][0][grid[0][0] % k] = 1
        for c in range(1, n):
            for rem in range(k):
                dp[0][c][(rem + grid[0][c]) % k] += dp[0][c - 1][rem]
        for r in range(1, m):
            for rem in range(k):
                dp[r][0][(rem + grid[r][0]) % k] += dp[r - 1][0][rem]
        for r in range(1, m):
            for c in range(1, n):
                for rem in range(k):
                    dp[r][c][(rem + grid[r][c]) % k] += dp[r][c - 1][rem] + dp[r - 1][c][rem]
        return dp[-1][-1][0] % 1000000007