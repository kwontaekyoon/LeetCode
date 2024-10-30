from bisect import bisect_left
from typing import List


class LIS:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        n = len(nums)
        LIS, LDS = [1] * n, [1] * n

        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    LIS[i] = max(LIS[i], LIS[j] + 1)
        
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, i, -1):
                if nums[i] > nums[j]:
                    LDS[i] = max(LDS[i], LDS[j] + 1)
        
        max_mountain_len = 0

        for i in range(1, n - 1):
            if LIS[i] > 1 and LDS[i] > 1:
                max_mountain_len = max(max_mountain_len, LIS[i] + LDS[i] - 1)
        
        return n - max_mountain_len

class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        n = len(nums)
        left, right = [0] * n, [0] * n

        dp = []
        for i in range(n):
            idx = bisect_left(dp, nums[i])
            if idx == len(dp):
                dp.append(nums[i])
            else:
                dp[idx] = nums[i]
            left[i] = len(dp)

        dp = []
        for i in range(n - 1, -1, -1):
            idx = bisect_left(dp, nums[i])
            if idx == len(dp):
                dp.append(nums[i])
            else:
                dp[idx] = nums[i]
            right[i] = len(dp)

        max_len = 0
        for i in range(n):
            if left[i] > 1 and right[i] > 1:
                max_len = max(max_len, left[i] + right[i] - 1)

        return n - max_len