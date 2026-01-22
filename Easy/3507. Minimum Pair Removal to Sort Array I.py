from typing import List


class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        def minPair(v: List[int]) -> int:
            min_sum = 10**9
            pos = -1
            for i in range(len(v) - 1):
                if v[i] + v[i + 1] < min_sum:
                    min_sum = v[i] + v[i + 1]
                    pos = i
            return pos
        ops = 0
        while nums != sorted(nums): 
            pos = minPair(nums)
            nums[pos] += nums[pos + 1]
            del nums[pos + 1]
            ops += 1
        return ops