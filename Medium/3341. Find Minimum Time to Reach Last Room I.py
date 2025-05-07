import heapq
from typing import List


class Solution:
    def minTimeToReach(self, move_time: List[List[int]]) -> int:
        n, m = len(move_time), len(move_time[0])
        minheap = []
        heapq.heappush(minheap, (0, 0, 0))
        visited = set([(0, 0)])
        while minheap:
            t, r, c = heapq.heappop(minheap)
            if r == n - 1 and c == m - 1:
                return t
            for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < m and (nr, nc) not in visited:
                    heapq.heappush(minheap, (max(move_time[nr][nc], t) + 1, nr, nc))
                    visited.add((nr, nc))
        return -1


class Solution1:
    def minTimeToReach(self, move_time: List[List[int]]) -> int:
        DIRS = ((0, 1), (0, -1), (1, 0), (-1, 0))
        n, m = len(move_time), len(move_time[0])
        mintime = [[float('inf') for _ in range(m)] for _ in range(n)]
        mintime[0][0] = 0
        minheap = []
        heapq.heappush(minheap, (0, 0, 0))
        while minheap:
            t, r, c = heapq.heappop(minheap)
            if r == n - 1 and c == m - 1:
                return t
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if not (0 <= nr < n) or not (0 <= nc < m):
                    continue
                nt = max(move_time[nr][nc], t) + 1
                if nt < mintime[nr][nc]:
                    mintime[nr][nc] = nt
                    heapq.heappush(minheap, (nt, nr, nc))
        return -1