DIRS = [[0, 1], [0, -1], [1, 0], [-1, 0]]

class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        R, C = len(grid), len(grid[0])
        dist = [[float('inf')] * C for _ in range(R)]
        dq = deque([(0, 0)])
        dist[0][0] = grid[0][0]
        while dq:
            r, c = dq.popleft()
            if r == R - 1 and c == C - 1:
                return dist[r][c] < health
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if 0 <= nr < R and 0 <= nc < C:
                    new_cost = grid[nr][nc] + dist[r][c]
                    if new_cost < dist[nr][nc]:
                        dist[nr][nc] = new_cost
                        if grid[nr][nc]:
                            dq.append((nr, nc))
                        else:
                            dq.appendleft((nr, nc))
        return False
