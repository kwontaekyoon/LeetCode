from functools import cache
from typing import List


class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        @cache
        def colSum(col: int) -> int:
            return sum(row[col] for row in mat)
        res = 0
        for row in mat:
            if sum(row) == 1:
                col = row.index(1)
                if colSum(col) == 1:
                    res += 1
        return res


class Solution1:
    def numSpecial(self, mat: List[List[int]]) -> int:
        cols = [0] * len(mat[0])
        for row in mat:
            for col, num in enumerate(row):
                cols[col] += num
        res = 0
        for row in mat:
            if not (row.count(1) == 1):
                continue
            for col, num in enumerate(row):
                if num and cols[col] == 1:
                    res += 1
                    break
        return res