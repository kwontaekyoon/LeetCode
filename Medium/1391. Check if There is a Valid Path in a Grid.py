DIRS = {
    1: [(0,-1),(0,1)],
    2: [(-1,0),(1,0)],
    3: [(0,-1),(1,0)],
    4: [(0,1),(1,0)],
    5: [(0,-1),(-1,0)],
    6: [(0,1),(-1,0)]
}

class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        rows, cols = len(grid), len(grid[0])
        visited = [[False] * cols for _ in range(rows)]
        queue = deque([(0, 0)])
        visited[0][0] = True
        while queue:
            r, c = queue.popleft()
            if r == rows - 1 and c == cols - 1:
                return True
            for dr, dc in DIRS[grid[r][c]]:
                nr, nc = r + dr, c + dc
                if not 0 <= nr < rows or not 0 <= nc < cols or visited[nr][nc]:
                    continue
                for bdr, bdc in DIRS[grid[nr][nc]]:
                    if nr + bdr == r and nc + bdc == c:
                        queue.append((nr, nc))
                        visited[nr][nc] = True
        return False
