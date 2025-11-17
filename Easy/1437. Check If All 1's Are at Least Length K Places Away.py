from typing import List


class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        if k == 0:
            return True
        last_idx = -k - 1
        for i, v in enumerate(nums):
            if v == 1:
                if i - last_idx <= k:
                    return False
                last_idx = i
        return True