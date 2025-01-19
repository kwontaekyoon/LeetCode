from heapq import heappop, heappush
from typing import List


class Solution:
    def trapRainWater(self, height: List[List[int]]) -> int:
        DIR = (0, 1, 0, -1, 0)
        R, C = len(height), len(height[0])
        if R <= 2 or C <= 2:
            return 0
        boundary = []
        for r in range(R):
            heappush(boundary, (height[r][0], r, 0))
            heappush(boundary, (height[r][-1], r, C - 1))
            height[r][0] = height[r][-1] = -1
        for c in range(1, C - 1):
            heappush(boundary, (height[0][c], 0, c))
            heappush(boundary, (height[-1][c], R - 1, c))
            height[0][c] = height[-1][c] = -1
        res, water_level = 0, 0
        while boundary:
            h, r, c = heappop(boundary)
            water_level = max(water_level, h)
            for d in range(4):
                nr, nc = r + DIR[d], c + DIR[d + 1]
                if nr < 0 or nr >= R or nc < 0 or nc >= C or height[nr][nc] == -1:
                    continue
                curr_h = height[nr][nc]
                if curr_h < water_level:
                    res += water_level - curr_h
                height[nr][nc] = -1
                heappush(boundary, (curr_h, nr, nc))
        return res