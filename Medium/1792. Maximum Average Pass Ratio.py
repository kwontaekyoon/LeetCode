from heapq import heappush, heapreplace
from typing import List


class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extra_students: int) -> float:
        N = len(classes)
        sum = 0
        heap = []
        for p, q in classes:
            sum += p / q
            heappush(heap, ((p - q) / (q * (q + 1)), p, q))
        for _ in range(extra_students):
            r, p, q = heap[0]
            if r == 0:
                break
            sum -= r
            nr = (p - q) / ((q + 1.0) * (q + 2.0))
            heapreplace(heap, (nr, p + 1, q + 1))
        return sum / N