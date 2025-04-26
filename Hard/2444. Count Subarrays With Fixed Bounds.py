from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        mini = maxi = badi = -1
        result = 0
        for i, v in enumerate(nums):
            if v < minK or v > maxK:
                badi = i
                continue
            if v == minK:
                mini = i
            if v == maxK:
                maxi = i
            if mini > badi and maxi > badi:
                result += max(min(mini, maxi) - badi, 0)
        return result