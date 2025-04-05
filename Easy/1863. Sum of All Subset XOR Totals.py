# O(N)
from functools import reduce
from operator import ior
from typing import List


class BitManupulation:
    def subsetXORSum(self, nums: List[int]) -> int:
        return reduce(ior, nums) * (1 << (len(nums) - 1))

# O(2^N)
class Recursion:
    def subsetXORSum(self, nums: List[int]) -> int:
        def recursion(i: int, curr_sum: int) -> None:
            if i == n:
                self.result += curr_sum
                return
            recursion(i + 1, curr_sum ^ nums[i])
            recursion(i + 1, curr_sum)
        self.result = 0
        n = len(nums)
        recursion(0, 0)
        return self.result
