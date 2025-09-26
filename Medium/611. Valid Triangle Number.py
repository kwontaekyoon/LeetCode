from typing import List


class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        result = 0
        for i in range(len(nums) - 1, -1, -1):
            lo, hi = 0, i - 1
            while lo < hi:
                if nums[lo] + nums[hi] > nums[i]:
                    result += hi - lo
                    hi -= 1
                else:
                    lo += 1
        return result