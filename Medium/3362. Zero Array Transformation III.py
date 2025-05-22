import heapq
from typing import List


class Solution:
    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        queries.sort(key = lambda x: x[0])
        available = []
        assigned = []
        count = 0
        k = 0
        for time in range(len(nums)):
            while assigned and assigned[0] < time:
                heapq.heappop(assigned)
            while k < len(queries) and queries[k][0] <= time:
                heapq.heappush(available, -queries[k][1])
                k += 1
            while len(assigned) < nums[time] and available and -available[0] >= time:
                heapq.heappush(assigned, -heapq.heappop(available))
                count += 1
            if len(assigned) < nums[time]:
                return -1
        return len(queries) - count