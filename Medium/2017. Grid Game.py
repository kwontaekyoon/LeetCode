from itertools import accumulate
from typing import List


class Optimized:
    def gridGame(self, grid: List[List[int]]) -> int:
        top_sum = sum(grid[0][1:])
        bottom_sum = 0
        optimal_result = max(top_sum, bottom_sum)
        for i in range(len(grid[0])-1):
            top_sum -= grid[0][i+1]
            bottom_sum += grid[1][i]
            result = max(top_sum, bottom_sum)
            if result < optimal_result:
                optimal_result = result
            else:
                break
        return optimal_result

class Solution1:
    def gridGame(self, grid: List[List[int]]) -> int:
        N = len(grid[0])
        suffix_first_row = list(accumulate(grid[0][::-1]))[::-1]
        prefix_second_row = list(accumulate(grid[1]))
        res = float('inf')
        for i in range(N):
            res = min(max(suffix_first_row[i+1] if i < N - 1 else 0, prefix_second_row[i-1] if i > 0 else 0), res)
        return res


