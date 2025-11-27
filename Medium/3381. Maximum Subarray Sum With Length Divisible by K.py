import itertools
from typing import List


class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        min_prefix = [float('inf')] * (k - 1) + [0]
        prefix_sum = 0
        max_sub_sum = -float('inf')
        for i, v in enumerate(nums):
            i %= k
            prefix_sum += v
            max_sub_sum = max(max_sub_sum, prefix_sum - min_prefix[i])
            min_prefix[i] = min(min_prefix[i], prefix_sum)
        return max_sub_sum # type: ignore


class TLE:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefix_sum = [0] + list(itertools.accumulate(nums))
        max_sum = -float('inf')
        for i in range(k, n + 1):
            for j in range(i - k, -1, -k):
                max_sum = max(max_sum, prefix_sum[i] - prefix_sum[j])
        return max_sum # type: ignore