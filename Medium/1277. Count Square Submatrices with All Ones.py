from typing import List


class DP:
    def countSquares(self, matrix: List[List[int]]) -> int:
        cnt = sum(matrix[i][0] for i in range(len(matrix))) + sum(matrix[0][i] for i in range(1, len(matrix[0])))
        for r in range(1, len(matrix)):
            for c in range(1, len(matrix[0])):
                if not matrix[r][c]:
                    continue
                matrix[r][c] += min(matrix[r - 1][c], matrix[r][c - 1], matrix[r - 1][c - 1])
                cnt += matrix[r][c]
        print(matrix)
        return cnt

class PrefixSum:
    def countSquares(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        cnt = sum(1 if matrix[i][0] else 0 for i in range(m))
        for r in range(m):
            for c in range(1, n):
                if matrix[r][c] == 0:
                    continue
                cnt += 1
                matrix[r][c] += matrix[r][c - 1]
                curr_min = matrix[r][c]
                for s in range(1, r + 1):
                    curr_min = min(curr_min, matrix[r - s][c])
                    if curr_min <= s:
                        break
                    cnt += 1
        return cnt