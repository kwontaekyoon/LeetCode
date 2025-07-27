from typing import List


class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        count = j = 0
        for i in range(1, len(nums) - 1):
            if nums[i] != nums[i + 1]:
                if (nums[i] > nums[j] and nums[i] > nums[i + 1]) or \
                   (nums[i] < nums[j] and nums[i] < nums[i + 1]):
                   count += 1
                j = i
        return count