from math import gcd
from typing import List


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        ones = nums.count(1)
        if ones:
            return n - ones
        min_sub = n + 1
        for i, g in enumerate(nums):
            for l, v in enumerate(nums[i + 1:]):
                g = gcd(g, v)
                if g == 1:
                    min_sub = min(min_sub, l + 1)
                    break
        return -1 if min_sub > n else n - 1 + min_sub