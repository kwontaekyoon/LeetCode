from typing import List


class Solution1:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        smallest_abs = 100000
        negs = 0
        result = 0
        for row in matrix:
            for num in row:
                smallest_abs = min(smallest_abs, abs(num))
                if num > 0:
                    result += num
                else:
                    negs += 1
                    result -= num
        return result if negs % 2 == 0 else result - smallest_abs * 2
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