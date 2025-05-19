from typing import List


class Solution:
    def triangleType(self, nums: List[int]) -> str:
        if sum(nums) <= max(nums) * 2:
            return 'none'
        unique_sides = len(set(nums))
        if unique_sides == 3:
            return 'scalene'
        if unique_sides == 2:
            return 'isosceles'
        return 'equilateral'