from math import ceil
from typing import List


class Solution:
    def minimumSize(self, nums: List[int], max_operations: int) -> int:
        low, high = 1, max(nums)
        while low < high:
            mid = (low + high) // 2
            if sum(ceil(num / mid) - 1 for num in nums) <= max_operations:
                high = mid
            else:
                low = mid + 1
        return high