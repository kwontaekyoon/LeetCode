from typing import List


class Solution:
    def largestCombination(self, nums: List[int]) -> int:
        max = 0
        for i in range(24):
            cnt = 0
            for num in nums:
                if num & (1 << i):
                    cnt += 1
            if cnt > max:
                max = cnt
        return max
