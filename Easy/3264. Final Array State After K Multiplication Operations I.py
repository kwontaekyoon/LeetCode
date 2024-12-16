from heapq import heapify, heappop, heappush
from typing import List


class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        minheap = [[nums[i], i] for i in range(len(nums))]
        heapify(minheap)
        for _ in range(k):
            num, idx = heappop(minheap)
            heappush(minheap, [num * multiplier, idx])
        while minheap:
            num, idx = heappop(minheap)
            nums[idx] = num
        return nums