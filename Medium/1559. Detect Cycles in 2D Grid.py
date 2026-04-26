DIRS = [(0, 1), (0, -1), (1, 0), (-1, 0)]
class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        rows, cols = len(grid), len(grid[0])
        visited = [[False] * cols for _ in range(rows)]
        for row in range(rows):
            for col in range(cols):
                if not visited[row][col]:
                    char = grid[row][col]
                    stack = [(row, col, -1, -1)]
                    visited[row][col] = True
                    while stack:
                        r, c, pr, pc = stack.pop()
                        for dr, dc in DIRS:
                            nr, nc = r + dr, c + dc
                            if nr == pr and nc == pc:
                                continue
                            if not 0 <= nr < rows or not 0 <= nc < cols:
                                continue
                            if grid[nr][nc] != grid[r][c]:
                                continue
                            if visited[nr][nc]:
                                return True
                            stack.append((nr, nc, r, c))
                            visited[nr][nc] = True
        return False
