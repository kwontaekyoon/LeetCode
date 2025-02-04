from typing import List


class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        tmp = nums[0]
        res = tmp
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                tmp += nums[i]
                res = max(tmp, res)
            else:
                tmp = nums[i]
        return res