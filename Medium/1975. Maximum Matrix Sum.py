from typing import List


class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        sum = 0
        neg_even = True
        min_num = 100001
        for row in matrix:
            for num in row:
                neg_even = not neg_even if num < 0 else neg_even
                num = abs(num)
                min_num = min(min_num, num)
                sum += num
        return sum if neg_even else sum - min_num * 2