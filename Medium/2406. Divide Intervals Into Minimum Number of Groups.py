from ast import List
from heapq import heappop, heappush

class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        min_heap = []
        for start, end in sorted(intervals, key = lambda interval: interval[0]):
            if min_heap and min_heap[0] < start:
                heappop(min_heap)
            heappush(min_heap, end)
        return len(min_heap)
        