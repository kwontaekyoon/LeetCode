from typing import List


class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        R, C = len(mat), len(mat[0])
        result = 0
        heights = [0] * C

        for row in mat:
            for c, v in enumerate(row):
                heights[c] = heights[c] + 1 if v else 0

            stack = []
            count = [0] * C
            for c, v in enumerate(heights):
                while stack and heights[stack[-1]] >= v:
                    stack.pop()
                if stack:
                    prev_index = stack[-1]
                    count[c] = count[prev_index] + v * (c - prev_index)
                else:
                    count[c] = v * (c + 1)
                stack.append(c)
                result += count[c]
        return result

# O(R * C * C)
class Solution1:
    def numSubmat(self, mat: List[List[int]]) -> int:
        R, C = len(mat), len(mat[0])
        for r in range(1, R):
            for c, v in enumerate(mat[r]):
                if v:
                    mat[r][c] += mat[r - 1][c]
        result = 0
        for row in mat:
            for c, v in enumerate(row):
                if not v:
                    continue
                min_val = v
                for j in range(c, -1, -1):
                    if not row[j]:
                        break
                    min_val = min(min_val, row[j])
                    result += min_val
        return result