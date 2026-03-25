class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        rows = len(grid)
        cols = len(grid[0])
        row_sums = [0] * rows
        col_sums = [0] * cols
        total_sum = 0
        for r in range(rows):
            for c in range(cols):
                row_sums[r] += grid[r][c]
                col_sums[c] += grid[r][c]
                total_sum += grid[r][c]
        if total_sum % 2:
            return False
        prefix = 0
        for row in row_sums:
            prefix += row
            if prefix * 2 == total_sum:
                return True
        prefix = 0
        for col in col_sums:
            prefix += col
            if prefix * 2 == total_sum:
                return True
        return False


class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        row_sums = [sum(row) for row in grid]
        total_sum = sum(row_sums)
        if total_sum % 2:
            return False
        prefix = 0
        for val in row_sums:
            prefix += val
            if 2 * prefix == total_sum:
                return True
        col_sums = [sum(grid[r][c] for r in range(len(grid))) for c in range(len(grid[0]))]
        prefix = 0
        for val in col_sums:
            prefix += val
            if 2 * prefix == total_sum:
                return True
        return False
