from typing import List


class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        if p == 0:
            return 0
        nums.sort()
        n, lo, hi = len(nums), 0, nums[-1] - nums[0]
        while lo < hi:
            mi, pairs = (lo + hi) // 2, 0
            i = 1
            while i < n:
                if nums[i] - nums[i - 1] <= mi:
                    pairs += 1
                    i += 1
                i += 1
            if pairs >= p:
                hi = mi
            else:
                lo = mi + 1
        return lo