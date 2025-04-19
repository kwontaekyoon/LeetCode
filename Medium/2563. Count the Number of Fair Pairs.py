from bisect import bisect_left, bisect_right
from typing import List


class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        cnt = 0
        for i in range(len(nums)):
            lower_end = bisect_left(nums, lower - nums[i], i + 1)
            upper_end = bisect_right(nums, upper - nums[i], i + 1)
            cnt += upper_end - lower_end
        return cnt
    
class Sorting:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        def count(limit: int) -> int:
            result = 0
            low, high = 0, len(nums) - 1
            while low < high:
                while low < high and nums[low] + nums[high] > limit:
                    high -= 1
                result += high - low
                low += 1
            return result
        nums.sort()
        return count(upper) - count(lower - 1)