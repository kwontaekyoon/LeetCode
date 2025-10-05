from typing import List, Set, Tuple

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        """
        Returns coordinates where water can flow to both the Pacific and Atlantic oceans.
        """
        if not heights or not heights[0]:
            return []

        rows, cols = len(heights), len(heights[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        def dfs(r: int, c: int, visited: Set[Tuple[int, int]]) -> None:
            """
            Depth-first search to mark reachable cells.
            """
            visited.add((r, c))
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if (
                    0 <= nr < rows and
                    0 <= nc < cols and
                    (nr, nc) not in visited and
                    heights[nr][nc] >= heights[r][c]
                ):
                    dfs(nr, nc, visited)

        pacific = set()
        atlantic = set()

        # Start DFS from Pacific border (top row and left column)
        for r in range(rows):
            dfs(r, 0, pacific)
        for c in range(cols):
            dfs(0, c, pacific)

        # Start DFS from Atlantic border (bottom row and right column)
        for r in range(rows):
            dfs(r, cols - 1, atlantic)
        for c in range(cols):
            dfs(rows - 1, c, atlantic)

        # Intersection: cells reachable by both oceans
        return [list(coord) for coord in pacific & atlantic]