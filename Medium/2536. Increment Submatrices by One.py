from typing import List


class OptimizedPrefixSum:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        diff = [[0] * (n + 1) for _ in range(n + 1)]
        for r1, c1, r2, c2 in queries:
            diff[r1][c1] += 1
            diff[r2 + 1][c1] -= 1
            diff[r1][c2 + 1] -= 1
            diff[r2 + 1][c2 + 1] += 1
        
        for r in range(n): # left to right
            run = 0
            for c in range(n):
                run += diff[r][c]
                diff[r][c] = run
        
        for c in range(n): # top to bot
            run = 0
            for r in range(n):
                run += diff[r][c]
                diff[r][c] = run
        return [row[:n] for row in diff[:n]]

class FirstPrefixSum:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        matrix = [[0 for _ in range(n)] for _ in range(n)]
        for r1, c1, r2, c2 in queries:
            for r in range(r1, r2 + 1):
                matrix[r][c1] += 1
                if c2 < n - 1:
                    matrix[r][c2 + 1] -= 1
        for r, row in enumerate(matrix):
            prefix = 0
            for c, v in enumerate(row):
                prefix += v
                matrix[r][c] = prefix
        return matrix