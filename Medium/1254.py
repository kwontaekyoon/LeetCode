class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        visit = [[False] * n for _ in range(m)]
        count = 0
        def bfs(x: int, y: int) -> bool:
            q = deque([(x, y)])
            visit[x][y] = True
            is_closed = True
            dirx = [0, 1, 0, -1]
            diry = [-1, 0, 1, 0]
            while q:
                x, y = q.popleft()
                for i in range(4):
                    r, c = x + dirx[i], y + diry[i]
                    if r < 0 or r >= m or c < 0 or c >= n:
                        is_closed = False
                    elif grid[r][c] == 0 and not visit[r][c]:
                        q.append((r, c))
                        visit[r][c] = True
            return is_closed
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0 and not visit[i][j] and bfs(i, j):
                    count += 1
        return count