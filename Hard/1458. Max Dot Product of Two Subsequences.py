from functools import cache
from typing import List


class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n1 = len(nums1)
        n2 = len(nums2)

        cache = [-float('inf')] * n2
        cache[0] = nums1[0] * nums2[0]

        for i1 in range(n1):
            for i2 in range(n2):
                old = cache[i2]
                if i1 == 0 and i2 == 0:
                    continue
                elif i1 == 0:
                    cache[i2] = max(cache[i2 - 1], nums1[i1] * nums2[i2])
                elif i2 == 0:
                    cache[i2] = max(cache[i2], nums1[i1] * nums2[i2])
                else:
                    cache[i2] = max(cache[i2], cache[i2 - 1], nums1[i1] * nums2[i2], temp + nums1[i1] * nums2[i2]) # type: ignore
                temp = old

        return int(cache[-1])

class Solution1:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        @cache
        def dp(i: int, j: int):
            if i == len(nums1) or j == len(nums2):
                return float('-inf')
            return max(nums1[i] * nums2[j] + dp(i + 1, j + 1), nums1[i] * nums2[j], dp(i + 1, j), dp(i, j + 1))
        return int(dp(0, 0))