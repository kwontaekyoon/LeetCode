from typing import List


class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        res = 0
        max_val = 0
        for val in values:
            max_val -= 1
            res = max(res, val + max_val)
            max_val = max(max_val, val)
        return res
