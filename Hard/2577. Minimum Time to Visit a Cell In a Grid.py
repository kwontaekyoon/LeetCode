from heapq import heappop, heappush
from typing import List


class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        if grid[0][1] > 1 and grid[1][0] > 1:
            return -1
        R, C = len(grid), len(grid[0])
        visited = [[False] * C for _ in range(R)]
        min_heap = [(0, 0, 0)]
        visited[0][0] = True
        while min_heap:
            ct, cr, cc = heappop(min_heap)
            for nr, nc in ((cr + 1, cc), (cr - 1, cc), (cr, cc + 1), (cr, cc - 1)):
                if nr < 0 or nc < 0 or nr >= R or nc >= C or visited[nr][nc]:
                    continue
                nt = ct + 1
                if grid[nr][nc] > nt:
                    nt += (grid[nr][nc] - ct) // 2 * 2
                if nr == R - 1 and nc == C - 1:
                    return nt
                heappush(min_heap, (nt, nr, nc))
                visited[nr][nc] = True
        return -1