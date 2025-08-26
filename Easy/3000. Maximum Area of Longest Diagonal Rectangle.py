from typing import List


class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        result = -1
        max_diagonal = -1
        for h, w in dimensions:
            curr_diagonal = h ** 2 + w ** 2
            if curr_diagonal > max_diagonal or (curr_diagonal == max_diagonal and h * w > result):
                result = h * w
                max_diagonal = curr_diagonal
        return result
