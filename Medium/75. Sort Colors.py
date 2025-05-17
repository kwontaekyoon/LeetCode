from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        zero_idx, two_idx = 0, len(nums) - 1
        curr_idx = 0
        while curr_idx <= two_idx:
            if nums[curr_idx] == 0:
                nums[zero_idx], nums[curr_idx] = nums[curr_idx], nums[zero_idx]
                zero_idx += 1
                curr_idx += 1
            elif nums[curr_idx] == 2:
                nums[two_idx], nums[curr_idx] = nums[curr_idx], nums[two_idx]
                two_idx -= 1
            else:
                curr_idx += 1