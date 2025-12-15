from typing import List


class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        prev = prices[0]
        desc_period = 1
        periods = 1
        for curr in prices[1:]:
            if curr == prev - 1:
                desc_period += 1
            else:
                desc_period = 1
            prev = curr
            periods += desc_period
        return periods