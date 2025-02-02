from typing import List


class Solution:
    def check(self, nums: List[int]) -> bool:
        def rotCheck(rest: List[int]) -> bool:
            for i in range(len(rest) - 1):
                if rest[i] > rest[i + 1]:
                    return False
            return True
        for i in range(len(nums) - 1):
            if nums[i] <= nums[i + 1]:
                continue
            if nums[-1] > nums[0]:
                return False
            return rotCheck(nums[i+1:])
        return True
