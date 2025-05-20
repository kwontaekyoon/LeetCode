from typing import List


class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        n = len(nums)
        prefix_sum = [0] * (n + 1)
        for l, r in queries:
            prefix_sum[l] -= 1
            prefix_sum[r + 1] += 1
        for i in range(1, n):
            prefix_sum[i] += prefix_sum[i - 1]
        for i in range(n):
            if prefix_sum[i] + nums[i] > 0:
                return False
        return True