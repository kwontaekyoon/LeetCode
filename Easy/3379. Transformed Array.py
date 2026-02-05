from typing import List


class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        N = len(nums)
        result = [0] * N
        for i, v in enumerate(nums):
            result[i] = nums[(i + v) % N]
        return result