import heapq
from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        operations = 0
        while len(nums) > 1 and nums[0] < k:
            heapq.heappush(nums, 2 * heapq.heappop(nums) + heapq.heappop(nums))
            operations += 1
        return operations