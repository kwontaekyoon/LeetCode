from typing import List


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        islands_to_size = [0, 0]
        curr_id = 2
        max_size = -1
        def dfs(r: int, c: int) -> int:
            if r < 0 or r >= R or c < 0 or c >= C or grid[r][c] != 1:
                return 0
            grid[r][c] = curr_id
            return 1 + dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1)
        for r, row in enumerate(grid):
            for c, num in enumerate(row):
                if num == 1:
                    islands_to_size.append(dfs(r, c))
                    max_size = max(islands_to_size[-1], max_size)
                    curr_id += 1
        if max_size < 0:
            return 1
        res = max_size
        for r, row in enumerate(grid):
            for c, num in enumerate(row):
                if num:
                    continue
                islands_around = set()
                curr_size = 1
                if r - 1 >= 0 and grid[r - 1][c] and grid[r - 1][c] not in islands_around:
                    islands_around.add(grid[r - 1][c])
                    curr_size += islands_to_size[grid[r - 1][c]]
                if r + 1 < R and grid[r + 1][c] and grid[r + 1][c] not in islands_around:
                    islands_around.add(grid[r + 1][c])
                    curr_size += islands_to_size[grid[r + 1][c]]
                if c - 1 >= 0 and grid[r][c - 1] and grid[r][c - 1] not in islands_around:
                    islands_around.add(grid[r][c - 1])
                    curr_size += islands_to_size[grid[r][c - 1]]
                if c + 1 < C and grid[r][c + 1] and grid[r][c + 1] not in islands_around:
                    islands_around.add(grid[r][c + 1])
                    curr_size += islands_to_size[grid[r][c + 1]]
                res = max(curr_size, res)
        return res