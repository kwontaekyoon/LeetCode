from typing import List


class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        max_window = 1
        j = 0
        for i in range(n):
            while j < n and nums[j] <= k * nums[i]:
                j += 1
            max_window = max(max_window, j - i)
        return n - max_window