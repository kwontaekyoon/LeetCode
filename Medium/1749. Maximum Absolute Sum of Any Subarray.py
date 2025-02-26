from typing import List


class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        max_prefix = 0
        min_prefix = 0
        prefix = 0
        for num in nums:
            prefix += num
            if prefix > 0:
                max_prefix = max(prefix, max_prefix)
            else:
                min_prefix = min(prefix, min_prefix)
        return max_prefix - min_prefix