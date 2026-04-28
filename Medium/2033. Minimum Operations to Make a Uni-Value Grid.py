from typing import List


class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        nums = [num for row in grid for num in row]
        rem = nums[0] % x
        for num in nums:
            if num % x != rem:
                return -1
        nums.sort()
        median = nums[len(nums) // 2]
        ops = 0
        for num in nums:
            ops += abs(num - median) // x
        return ops

class Solution1:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        nums = sorted([num for row in grid for num in row])
        for idx, num in enumerate(nums):
            if (num - nums[idx - 1]) % x:
                return -1
        median = nums[len(nums) // 2]
        return sum(abs(num - median) // x for num in nums)
