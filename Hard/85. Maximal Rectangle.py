from typing import List


class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        R, C = len(matrix), len(matrix[0])
        for r in range(R):
            for c in range(C):
                matrix[r][c] = int(matrix[r][c]) # type: ignore
        for r in range(R):
            for c in range(1, C):
                if matrix[r][c] == 1:
                    matrix[r][c] += matrix[r][c - 1]
        result = 0
        for c in range(C):
            for r in range(R):
                width = matrix[r][c]
                if width == 0:
                    continue
                curr_width = width
                for k in range(r, R):
                    if matrix[k][c] == 0:
                        break
                    curr_width = min(curr_width, matrix[k][c])
                    result = max(result, curr_width * (k - r + 1))
        return result # type: ignore