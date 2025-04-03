from typing import List


class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        maxval = maxdiff = result = 0
        for num in nums:
            result = max(maxdiff * num, result)
            maxdiff = max(maxval - num, maxdiff)
            maxval = max(num, maxval)
        return result