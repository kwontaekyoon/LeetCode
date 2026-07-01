DIRS = [[0, 1], [0, -1], [1, 0], [-1, 0]]

class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        if grid[0][0] or grid[-1][-1]:
            return 0
        N, Q = len(grid), deque()
        for r in range(N):
            for c in range(N):
                if grid[r][c]:
                    Q.append((r, c))
        while Q:
            r, c = Q.popleft()
            safety = grid[r][c]
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if 0 <= nr < N and 0 <= nc < N and not grid[nr][nc]:
                    grid[nr][nc] = safety + 1
                    Q.append((nr, nc))
        PQ = [(-grid[0][0], 0, 0)]
        while PQ:
            safety, r, c = heapq.heappop(PQ)
            safety *= -1
            if r == N - 1 and c == N - 1:
                return safety - 1
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if 0 <= nr < N and 0 <= nc < N and grid[nr][nc] > 0:
                    heapq.heappush(PQ, (-min(safety, grid[nr][nc]), nr, nc))
                    grid[nr][nc] *= -1
        return grid[-1][-1] - 1
