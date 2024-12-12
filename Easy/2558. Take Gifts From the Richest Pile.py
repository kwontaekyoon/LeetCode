from heapq import heapify, heappop, heappush
from math import floor
from typing import List


class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        maxheap = [-gift for gift in gifts]
        heapify(maxheap)
        for _ in range(k):
            heappush(maxheap, -1 * floor((-1 * heappop(maxheap)) ** 0.5))
        return -1 * sum(maxheap)