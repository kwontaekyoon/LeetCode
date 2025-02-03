from typing import List


class Solution1:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        tmp, res = 1, 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                tmp += 1
                res = max(tmp, res)
            else:
                tmp = 1
        tmp = 1
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                tmp += 1
                res = max(tmp, res)
            else:
                tmp = 1
        return res

class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        n, res, inc, dec = len(nums), 1, 1, 1
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                inc += 1
                dec = 1
            elif nums[i] < nums[i - 1]:
                inc = 1
                dec += 1
            else:
                inc = dec = 1
            res = max(inc, dec, res)
        return res