import heapq
from typing import List


class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        n = len(nums) // 3
        # maxheap for smallest sum
        maxheap = [-v for v in nums[:n]]
        heapq.heapify(maxheap)
        dp1 = [-sum(maxheap)]
        for i in range(n, 2 * n):
            heapq.heappush(maxheap, -nums[i])
            dp1.append(dp1[-1] + nums[i] + heapq.heappop(maxheap))
        # minheap for biggest sum
        minheap = [v for v in nums[2 * n:]]
        heapq.heapify(minheap)
        dp2 = [sum(minheap)]
        for i in range(2 * n - 1, n - 1, -1):
            heapq.heappush(minheap, nums[i])
            dp2.append(dp2[-1] + nums[i] - heapq.heappop(minheap))
        return min(v1 - v2 for v1, v2 in zip(dp1, dp2[::-1]))