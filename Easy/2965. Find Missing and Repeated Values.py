from typing import List


class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        missing = (n * n) * (n * n + 1) // 2
        seen = set()
        for row in grid:
            for num in row:
                if num in seen:
                    repeating = num
                else:
                    seen.add(num)
                    missing -= num
        return [repeating, missing]
