from typing import List


class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        min_r = min_c = float('inf')
        max_r = max_c = -1
        for r, row in enumerate(grid):
            for c, v in enumerate(row):
                if v:
                    min_r = min(min_r, r)
                    max_r = max(max_r, r)
                    min_c = min(min_c, c)
                    max_c = max(max_c, c)
        return (max_r - min_r + 1) * (max_c - min_c + 1) # type: ignore