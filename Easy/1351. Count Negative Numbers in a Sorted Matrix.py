from typing import List


class Solution1:
    def countNegatives(self, grid: List[List[int]]) -> int:
        count = 0
        for row in grid:
            for num in row:
                if num < 0:
                    count += 1
        return count

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        r, c = 0, C - 1
        count = 0
        while r < R and c > -1:
            if grid[r][c] < 0:
                count += R - r
                c -= 1
            else:
                r += 1
        return count