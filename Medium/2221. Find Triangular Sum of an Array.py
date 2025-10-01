from math import comb
from typing import List


class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0
        for i in range(n):
            result = (result + comb(n - 1, i) * nums[i]) % 10
        return result

class BF:
    def triangularSum(self, nums: List[int]) -> int:
        while len(nums) > 1:
            nums = [(nums[i] + nums[i + 1]) % 10 for i in range(len(nums) - 1)]
        return nums[0]
