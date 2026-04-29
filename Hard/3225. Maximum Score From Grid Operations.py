class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n == 1:
            return 0
        dp0 = [0] * (n + 1)
        dp1 = [0] * (n + 1)
        for c in range(1, n):
            new_dp0 = [0] * (n + 1)
            new_dp1 = [0] * (n + 1)
            for r in range(n + 1):
                prev = 0
                curr = sum(grid[x][c] for x in range(r))
                for y in range(n + 1):
                    if y > 0 and y <= r:
                        curr -= grid[y - 1][c]
                    if y > r:
                        prev += grid[y - 1][c - 1]
                    new_dp0[y] = max(new_dp0[y], prev + dp0[r], dp1[r])
                    new_dp1[y] = max(new_dp1[y], curr + dp1[r], curr + prev + dp0[r])
            dp0, dp1 = new_dp0, new_dp1
        return max(dp1)
