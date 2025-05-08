import heapq
from typing import List


class Solution:
    def minTimeToReach(self, move_time: List[List[int]]) -> int:
        R, C = len(move_time), len(move_time[0])
        minheap = [(0, 0, 0, 1)]
        move_time[0][0] = -1
        while minheap:
            t, r, c, n = heapq.heappop(minheap)
            if r == R - 1 and c == C - 1:
                return t
            for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < R and 0 <= nc < C and move_time[nr][nc] > -1:
                    heapq.heappush(minheap, (max(move_time[nr][nc], t) + n, nr, nc, n % 2 + 1))
                    move_time[nr][nc] = -1
        return -1