from typing import List


class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        R, C = len(grid), len(grid[0])
        magic_cnt = 0

        def isMagic(r: int, c: int) -> bool:
            if grid[r + 1][c + 1] != 5:
                return False
            dig_sum1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]
            dig_sum2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]
            if  dig_sum1 != dig_sum2:
                return False
            num_set = [False] * 10
            row_sum = [0] * 3
            col_sum = [0] * 3
            for u in range(3):
                for v in range(3):
                    num = grid[r + u][c + v]
                    if not (0 < num < 10) or num_set[num]:
                        return False
                    num_set[num] = True
                    row_sum[u] += num
                    col_sum[v] += num
            return row_sum[0] == row_sum[1] == row_sum[2] == col_sum[0] == col_sum[1] == col_sum[2] == dig_sum1

        for r in range(R - 2):
            for c in range(C - 2):
                if isMagic(r, c):
                    magic_cnt += 1
                    
        return magic_cnt