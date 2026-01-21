from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        for i, n in enumerate(nums):
            res = -1
            d = 1
            while n & d:
                res = n - d
                d <<= 1
            nums[i] = res
        return nums