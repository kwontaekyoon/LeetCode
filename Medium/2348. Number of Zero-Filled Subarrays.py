from typing import List


class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        result = streak = 0
        for num in nums:
            if num == 0:
                streak += 1
                result += streak
            else:
                streak = 0
        return result