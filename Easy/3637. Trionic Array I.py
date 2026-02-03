from typing import List


class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        i, n = 0, len(nums)
        if n < 4:
            return False
        j = i
        while j < n - 1 and nums[j + 1] > nums[j]:
            j += 1
        if j == i or j == n - 1:
            return False
        i = j
        while j < n - 1 and nums[j + 1] < nums[j]:
            j += 1
        if j == i or j == n - 1:
            return False
        i = j
        while j < n - 1 and nums[j + 1] > nums[j]:
            j += 1
        return j != i and j == n - 1