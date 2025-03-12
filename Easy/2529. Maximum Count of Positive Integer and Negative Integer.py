import bisect
from typing import List

# O(log(n))
class BinarySearch:
    def maximumCount(self, nums: List[int]) -> int:
        return max(bisect.bisect_left(nums, 0), len(nums) - bisect.bisect_right(nums, 0))        

# O(n)
class Solution1:
    def maximumCount(self, nums: List[int]) -> int:
        n, neg, pos = len(nums), 0, 0
        for i in range(n):
            if nums[i] >= 0:
                break
            neg += 1
        for i in range(n - 1, -1, -1):
            if nums[i] <= 0:
                break
            pos += 1
        return max(neg, pos)