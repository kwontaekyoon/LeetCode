from typing import List


class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        left_sum, right_sum = 0, sum(nums)
        count = 0
        for num in nums[:-1]:
            left_sum += num
            right_sum -= num
            if (left_sum - right_sum) % 2 == 0:
                count += 1
        return count