from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for r, row in enumerate(triangle):
            if r == 0:
                continue
            for c, num in enumerate(row):
                if c == 0:
                    triangle[r][c] += triangle[r - 1][c]
                elif c == r:
                    triangle[r][c] += triangle[r - 1][c - 1]
                else:
                    triangle[r][c] += min(triangle[r - 1][c - 1], triangle[r - 1][c])
        return min(triangle[-1])
