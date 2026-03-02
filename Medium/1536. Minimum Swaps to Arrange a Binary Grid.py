from typing import List


class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)
        zeros_on_right = []
        for row in grid:
            zeros = 0
            for col in row[::-1]:
                if col:
                    break
                zeros += 1
            zeros_on_right.append(zeros)
        swaps = 0
        for i in range(n):
            needed = n - i - 1
            j = i
            while j < n and zeros_on_right[j] < needed:
                j += 1
            if j == n:
                return -1
            while j > i:
                zeros_on_right[j], zeros_on_right[j - 1] = zeros_on_right[j - 1], zeros_on_right[j]
                j -= 1
                swaps += 1
        return swaps