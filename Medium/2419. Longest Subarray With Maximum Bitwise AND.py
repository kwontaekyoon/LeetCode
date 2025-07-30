from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        max_num = streak = longest_subarray = 0
        for num in nums:
            if num == max_num:
                streak += 1
                longest_subarray = max(longest_subarray, streak)
            elif num > max_num:
                max_num = num
                longest_subarray = streak = 1
            else:
                streak = 0
        return longest_subarray