from typing import List


class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()
        min_diff = nums[-1] - nums[-k]
        for i in range(len(nums) - k):
            min_diff = min(min_diff, nums[i + k - 1] - nums[i])
        return min_diff