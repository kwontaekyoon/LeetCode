from functools import reduce
from operator import xor
from typing import List


class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        return (reduce(xor, nums1) if len(nums2) % 2 else 0) ^ (reduce(xor, nums2) if len(nums1) % 2 else 0)

class Solution1:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        res = 0
        if len(nums1) % 2:
            for num in nums2:
                res ^= num
        if len(nums2) % 2:
            for num in nums1:
                res ^= num
        return res
