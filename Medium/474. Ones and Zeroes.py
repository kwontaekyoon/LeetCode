from collections import defaultdict
from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = defaultdict(int)
        dp[(0, 0)] = 0
        for s in strs:
            curr_ones, curr_zeros = s.count('1'), s.count('0')
            for (prev_zeros, prev_ones), prev_len in list(dp.items()):
                next_zeros, next_ones = prev_zeros + curr_zeros, prev_ones + curr_ones
                if next_zeros <= m and next_ones <= n:
                    dp[(next_zeros, next_ones)] = max(dp[(next_zeros, next_ones)], prev_len + 1)
        return max(dp.values())

class Solution1:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for S in strs:
            zeros, ones = S.count('0'), S.count('1')
            for i in range(m, zeros - 1, -1):
                for j in range(n, ones - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1)
        return dp[m][n]