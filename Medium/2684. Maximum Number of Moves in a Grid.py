from typing import List


class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        can_go = set(range(len(grid)))
        for c in range(len(grid[0]) - 1):
            new_can_go = set()
            for r in can_go:
                if grid[r][c + 1] > grid[r][c]:
                    new_can_go.add(r)
                if r > 0 and grid[r - 1][c + 1] > grid[r][c]:
                    new_can_go.add(r - 1)
                if r < len(grid) - 1 and grid[r + 1][c + 1] > grid[r][c]:
                    new_can_go.add(r + 1)
            if not new_can_go:
                return c
            can_go = new_can_go
        return len(grid[0]) - 1