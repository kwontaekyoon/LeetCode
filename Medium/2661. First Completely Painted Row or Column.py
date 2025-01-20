from typing import List


class Optimized:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        R, C = len(mat), len(mat[0])
        num_to_row, num_to_col = [0] * (R * C + 1), [0] * (R * C + 1)
        for r, row in enumerate(mat):
            for c, num in enumerate(row):
                num_to_row[num] = r
                num_to_col[num] = c
        rows, cols = [0] * R, [0] * C
        for i, num in enumerate(arr):
            rows[num_to_row[num]] += 1
            if rows[num_to_row[num]] == C:
                return i
            cols[num_to_col[num]] += 1
            if cols[num_to_col[num]] == R:
                return i
        return -1


class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        R, C = len(mat), len(mat[0])
        num_to_idx = [0] * (R * C + 1)
        for i in range(len(arr)):
            num_to_idx[arr[i]] = i
        rows, cols = [0] * R, [0] * C
        for r in range(R):
            for c in range(C):
                rows[r] = max(rows[r], num_to_idx[mat[r][c]])
                cols[c] = max(cols[c], num_to_idx[mat[r][c]])
        return min(rows + cols)
        