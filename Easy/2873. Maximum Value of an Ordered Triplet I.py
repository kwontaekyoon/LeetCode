from typing import List


class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        result = max_val = max_diff = 0
        for num in nums:
            result = max(num * max_diff, result)
            max_diff = max(max_val - num, max_diff)
            max_val = max(num, max_val)
        return result