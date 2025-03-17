from typing import Counter, List


class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        for v in Counter(nums).values():
            if v & 1:
                return False
        return True