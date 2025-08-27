from functools import cache
from typing import List


class MemoziationDFS:
    DIRS = ((1, 1), (1, -1), (-1, -1), (-1, 1))

    def lenOfVDiagonal(self, grid):
        m, n = len(grid), len(grid[0])
        memo = [[[0] * (1 << 3) for _ in range(n)] for _ in range(m)]
        ans = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] != 1:
                    continue
                maxs = [m - i, j + 1, i + 1, n - j]
                for k in range(4):
                    if maxs[k] > ans:
                        ans = max(ans, self.dfs(i, j, k, 1, 2, grid, memo) + 1)
        return ans

    def dfs(self, i, j, k, canTurn, target, grid, memo):
        m, n = len(grid), len(grid[0])
        i += self.DIRS[k][0]
        j += self.DIRS[k][1]
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] != target:
            return 0

        mask = (k << 1) | canTurn
        if memo[i][j][mask] > 0:
            return memo[i][j][mask]

        res = self.dfs(i, j, k, canTurn, 2 - target, grid, memo)
        if canTurn == 1:
            maxs = [m - i - 1, j, i, n - j - 1]
            nk = (k + 1) % 4
            if maxs[nk] > res:
                res = max(res, self.dfs(i, j, nk, 0, 2 - target, grid, memo))
        memo[i][j][mask] = res + 1
        return memo[i][j][mask]

class DFS:
    def lenOfVDiagonal(self, grid: List[List[int]]) -> int:
        DIRS = ((1, 1), (1, -1), (-1, -1), (-1, 1))
        R, C = len(grid), len(grid[0])
        result = 0
        @cache
        def dfs(r: int, c: int, target: int, d: int, can_turn: int) -> int:
            if not (0 <= r < R and 0 <= c < C) or grid[r][c] != target:
                return 0
            next_target = 0 if target == 2 else 2
            max_length = dfs(r + DIRS[d][0], c + DIRS[d][1], next_target, d, can_turn) + 1
            if can_turn > 0 and target != 1:
                d = (d + 1) % 4
                max_length = max(max_length, dfs(r + DIRS[d][0], c + DIRS[d][1], next_target, d, 0) + 1)
            return max_length
        for r, row in enumerate(grid):
            for c, v in enumerate(row):
                if v == 1:
                    for d in range(4):
                        result = max(result, dfs(r, c, 1, d, 1))
        return result