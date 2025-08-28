from collections import defaultdict
import heapq
from typing import List


class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        diags = defaultdict(list)
        for r in range(n):
            for c in range(n):
                key = r - c
                heapq.heappush(diags[key], grid[r][c] * (1 if key < 0 else -1))
        for r in range(n):
            for c in range(n):
                key = r - c
                grid[r][c] = heapq.heappop(diags[key]) * (1 if key < 0 else -1)
        return grid