from collections import defaultdict
from typing import List


class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        m = len(target)
        n = len(words[0])

        MOD = 10**9 + 7

        pos_cnt = []
        for j in range(n):
            char2cnt = defaultdict(int)
            for word in words:
                char2cnt[word[j]] += 1
            pos_cnt.append(char2cnt)

        dp = [[0]*n for _ in range(2)]
        for j in range(n - m + 1):
            if j == 0:
                dp[0][0] = pos_cnt[0][target[0]] % MOD
            else:
                dp[0][j] = (dp[0][j - 1] + pos_cnt[j][target[0]]) % MOD
        for i in range(1, m):
            dp[i % 2] = [0] * n
            for j in range(i, n - m + i + 1):
                dp[i % 2][j] = (dp[i % 2][j - 1] + dp[(i - 1) % 2][j - 1] * pos_cnt[j][target[i]]) % MOD
        return dp[(m - 1) % 2][n - 1]