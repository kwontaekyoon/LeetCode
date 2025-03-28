import heapq
from typing import List


class Solution:
    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        R, C = len(grid), len(grid[0])
        result = [0 for _ in range(len(queries))]
        pq = [(grid[0][0], 0, 0)]
        visited = [[False for _ in range(C)] for _ in range(R)]
        visited[0][0] = True
        point = 0
        for lim, idx in sorted((val, idx) for idx, val in enumerate(queries)):
            while pq and pq[0][0] < lim:
                _, r, c = heapq.heappop(pq)
                point += 1
                if 0 <= r + 1 < R and not visited[r + 1][c]:
                    heapq.heappush(pq, (grid[r + 1][c], r + 1, c))
                    visited[r + 1][c] = True
                if 0 <= r - 1 < R and not visited[r - 1][c]:
                    heapq.heappush(pq, (grid[r - 1][c], r - 1, c))
                    visited[r - 1][c] = True
                if 0 <= c + 1 < C and not visited[r][c + 1]:
                    heapq.heappush(pq, (grid[r][c + 1], r, c + 1))
                    visited[r][c + 1] = True
                if 0 <= c - 1 < C and not visited[r][c - 1]:
                    heapq.heappush(pq, (grid[r][c - 1], r, c - 1))
                    visited[r][c - 1] = True
            result[idx] = point
        return result