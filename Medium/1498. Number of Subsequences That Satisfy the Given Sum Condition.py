from typing import List


class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        result = 0
        l, r = 0, len(nums) - 1
        while l <= r:
            if nums[l] + nums[r] <= target:
                result += 1 << (r - l)
                l += 1
            else:
                r -= 1
        return result % (10 ** 9 + 7)