from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        R, C = len(matrix), len(matrix[0])
        row_check = col_check = 0
        for r, row in enumerate(matrix):
            for c, num in enumerate(row):
                if matrix[r][c] == 0:
                    row_check |= (1 << r)
                    col_check |= (1 << c)
        for r in range(R):
            if row_check & (1 << r):
                matrix[r] = [0] * C
        for c in range(C):
            if col_check & (1 << c):
                for row in matrix:
                    row[c] = 0

class BF:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        R, C = len(matrix), len(matrix[0])
        row_check, col_check = [False] * R, [False] * C
        for r, row in enumerate(matrix):
            for c, num in enumerate(row):
                if matrix[r][c] == 0:
                    row_check[r] = True
                    col_check[c] = True
        for r in range(R):
            if row_check[r]:
                for c in range(C):
                    matrix[r][c] = 0
        for c in range(C):
            if col_check[c]:
                for r in range(R):
                    matrix[r][c] = 0