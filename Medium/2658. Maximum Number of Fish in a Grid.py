from collections import deque
from typing import List


class DFS:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        def dfs(r: int, c: int) -> int:
            if r < 0 or r >= R or c < 0 or c >= C or not grid[r][c]:
                return 0
            curr_fish = grid[r][c]
            grid[r][c] = 0
            return curr_fish + dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1)
        res = 0
        for r in range(R):
            for c in range(C):
                if grid[r][c]:
                    res = max(dfs(r, c), res)
        return res


class BFS:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        DIRS = ((1, 0), (0, -1), (-1, 0), (0, 1))
        R, C = len(grid), len(grid[0])
        def bfs(r: int, c: int) -> int:
            queue = deque([(r, c)])
            total_fish = grid[r][c]
            grid[r][c] = 0
            while queue:
                curr_r, curr_c = queue.popleft()
                for dr, dc in DIRS:
                    next_r, next_c = curr_r + dr, curr_c + dc
                    if 0 <= next_r < R and 0 <= next_c < C and grid[next_r][next_c]:
                        queue.append((next_r, next_c))
                        total_fish += grid[next_r][next_c]
                        grid[next_r][next_c] = 0
            return total_fish
        max_fish = 0
        for r in range(R):
            for c in range(C):
                if grid[r][c]:
                    max_fish = max(bfs(r, c), max_fish)
        return max_fish