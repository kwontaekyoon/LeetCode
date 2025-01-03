from typing import List


class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        n = len(nums)
        left, right = 0, sum(nums)
        res = 0
        for i in range(n - 1):
            left += nums[i]
            right -= nums[i]
            res += 1 if left >= right else 0
        return res