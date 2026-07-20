class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        R, C = len(grid), len(grid[0])
        res = [[None] * C for _ in range(R)]
        for r, row in enumerate(grid):
            for c, val in enumerate(row):
                curr_id = r * C + c
                next_id = (curr_id + k) % (R * C)
                res[next_id // C][next_id % C] = val
        return res