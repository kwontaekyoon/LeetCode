from bisect import bisect_right
import heapq
from typing import List

class SortingWithHeap:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        events.sort(key = lambda x: x[0])
        heap = []
        max_prev_value = 0
        max_two_events = 0
        for start, end, value in events:
            while heap and heap[0][0] < start:
                _, prev_value = heapq.heappop(heap)
                max_prev_value = max(max_prev_value, prev_value)
            max_two_events = max(max_two_events, value + max_prev_value)
            heapq.heappush(heap, (end, value))
        return max_two_events
    
class Opitimized:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        max_weights = [0]
        max_weight_ends = [-1]

        events.sort(key = lambda x: x[1])

        max_two = 0
        for start, end, weight in events:
            index = bisect_right(max_weight_ends, start - 1) - 1
            
            if weight + max_weights[index] > max_two:
                max_two = weight + max_weights[index]
            if weight > max_weights[-1]:
                max_weights.append(weight)
                max_weight_ends.append(end)
        
        return max_two

class BinarySearch:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        N = len(events)
        events.sort()
        suffix_max = [0] * N
        suffix_max[N - 1] = events[N - 1][2]
        for i in range(N - 2, -1, -1):
            suffix_max[i] = max(events[i][2], suffix_max[i + 1])
        max_sum = 0
        for i in range(N):
            left, right = i + 1, N - 1
            next_index = -1
            while left <= right:
                mid = (left + right) // 2
                if events[mid][0] > events[i][1]:
                    next_index = mid
                    right = mid - 1
                else:
                    left = mid + 1
            if next_index != -1:
                max_sum = max(max_sum, events[i][2] + suffix_max[next_index])
            max_sum = max(max_sum, events[i][2])
        return max_sum