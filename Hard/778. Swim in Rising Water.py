import heapq
from typing import List, Tuple

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        """
        Returns the minimum time required to swim from the top-left to the bottom-right corner.
        Uses Dijkstra's algorithm (min-heap) to always expand the lowest cost cell.
        """
        n = len(grid)
        # Priority queue stores (current max water level, row, col)
        min_heap: List[Tuple[int, int, int]] = [(grid[0][0], 0, 0)]
        visited = set([(0, 0)])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        while min_heap:
            curr_level, row, col = heapq.heappop(min_heap)
            # If we've reached the bottom-right cell, return the current max water level
            if row == n - 1 and col == n - 1:
                return curr_level
            for dr, dc in directions:
                nr, nc = row + dr, col + dc
                if 0 <= nr < n and 0 <= nc < n and (nr, nc) not in visited:
                    # The water level at the next cell is the max of current and next cell's value
                    next_level = max(curr_level, grid[nr][nc])
                    heapq.heappush(min_heap, (next_level, nr, nc))
                    visited.add((nr, nc))
        # If unreachable, return -1 (should not happen for valid input)
        return -1

# Time Complexity: O(n^2 * log n)
# Space Complexity: O(n^2)