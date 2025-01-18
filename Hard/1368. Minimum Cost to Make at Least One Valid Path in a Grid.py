from collections import deque
from typing import List


class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        costs = [[float('inf')] * C for _ in range(R)]
        costs[0][0] = 0
        dq = deque([(0, 0)])
        dirs = ((0, 1), (0, -1), (1, 0), (-1, 0))
        while dq:
            r, c = dq.popleft()
            for i, (dr, dc) in enumerate(dirs):
                nr, nc = r + dr, c + dc
                cost = 0 if grid[r][c] == i + 1 else 1
                if 0 <= nr < R and 0 <= nc < C and costs[nr][nc] > costs[r][c] + cost:
                    costs[nr][nc] = costs[r][c] + cost
                    if cost == 1:
                        dq.append((nr, nc))
                    else:
                        dq.appendleft((nr, nc))
        return costs[R-1][C-1]
