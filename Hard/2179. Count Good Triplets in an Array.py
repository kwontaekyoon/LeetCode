import bisect
from typing import List


class Solution:
    def goodTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        map = {}
        for i, v in enumerate(nums1):
            map[v] = i
        n = len(nums2)
        result = 0
        st = []
        for num in nums2:
            idx = map[num]
            left = bisect.bisect_left(st, idx)
            right = (n - 1 - idx) - (len(st) - left)
            result += left * right
            bisect.insort(st, idx)
        return result