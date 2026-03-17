class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        R, C = len(matrix), len(matrix[0])
        for c in range(C):
            for r in range(1, R):
                if matrix[r][c]:
                    matrix[r][c] += matrix[r - 1][c]
        res = 0
        for row in matrix:
            for c, v in enumerate(sorted(row, reverse = True)):
                if not v:
                    break
                res = max(v * (c + 1), res)
        return res
