from collections import Counter
from typing import List


class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        n = len(nums)
        for num, cnt in Counter(nums).items():
            if cnt * 2 > n:
                dom, dom_R = num, cnt
                break
        if not dom:
            return -1
        dom_L = 0
        for i in range(n - 1):
            if nums[i] == dom:
                dom_L += 1
                dom_R -= 1
            if dom_L * 2 > i + 1 and dom_R * 2 > n - i - 1:
                return i
        return -1