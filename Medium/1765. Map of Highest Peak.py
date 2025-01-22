from collections import deque
from typing import List


class OptimizedBFS:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        R, C = len(isWater), len(isWater[0])
        graph = [[-1] * C for _ in range(R)]
        queue = deque()
        for r, row in enumerate(isWater):
            for c, water in enumerate(row):
                if water:
                    graph[r][c] = 0
                    queue.append((r, c))
        while queue:
            r, c = queue.popleft()
            if c + 1 < C and graph[r][c+1] < 0:
                graph[r][c+1] = graph[r][c] + 1
                queue.append((r, c + 1))
            if c - 1 >= 0 and graph[r][c-1] < 0:
                graph[r][c-1] = graph[r][c] + 1
                queue.append((r, c - 1))
            if r + 1 < R and graph[r+1][c] < 0:
                graph[r+1][c] = graph[r][c] + 1
                queue.append((r + 1, c))
            if r - 1 >= 0 and graph[r-1][c] < 0:
                graph[r-1][c] = graph[r][c] + 1
                queue.append((r - 1, c))
        return graph

class BFS:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        R, C = len(isWater), len(isWater[0])
        graph = [[float('inf')] * C for _ in range(R)]
        queue = deque()
        seen = set()
        for r, row in enumerate(isWater):
            for c, water in enumerate(row):
                if water:
                    seen.add((r, c))
                    graph[r][c] = 0
                    queue.append((r, c))
        while queue:
            r, c = queue.popleft()
            if c + 1 < C and (r, c + 1) not in seen:
                seen.add((r, c + 1))
                graph[r][c+1] = graph[r][c] + 1
                queue.append((r, c + 1))
            if c - 1 >= 0 and (r, c - 1) not in seen:
                seen.add((r, c - 1))
                graph[r][c-1] = graph[r][c] + 1
                queue.append((r, c - 1))
            if r + 1 < R and (r + 1, c) not in seen:
                seen.add((r + 1, c))
                graph[r+1][c] = graph[r][c] + 1
                queue.append((r + 1, c))
            if r - 1 >= 0 and (r - 1, c) not in seen:
                seen.add((r - 1, c))
                graph[r-1][c] = graph[r][c] + 1
                queue.append((r - 1, c))
        return graph

class Looping:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        R = len(isWater)
        C = len(isWater[0])
        height = [[float('inf')] * C for _ in range(R)]

        for i in range(R):
            for j in range(C):
                if isWater[i][j] == 1:
                    height[i][j] = 0
                else:
                    if i > 0:
                        height[i][j] = min(height[i][j], height[i - 1][j] + 1)
                    if j > 0:
                        height[i][j] = min(height[i][j], height[i][j - 1] + 1)

        for i in range(R - 1, -1, -1):
            for j in range(C - 1, -1, -1):
                if i < R - 1:
                    height[i][j] = min(height[i][j], height[i + 1][j] + 1)
                if j < C - 1:
                    height[i][j] = min(height[i][j], height[i][j + 1] + 1)

        return height