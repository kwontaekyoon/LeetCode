from typing import List


class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        dict = {}
        max_streak = -1
        for curr in sorted(set(nums), reverse = True):
            if curr ** 2 in dict:
                dict[curr] = dict[curr ** 2] + 1
                max_streak = max(max_streak, dict[curr])
            else:
                dict[curr] = 1
        return max_streak
