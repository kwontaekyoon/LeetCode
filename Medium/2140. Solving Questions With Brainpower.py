from typing import List


class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0] * n
        dp[-1] = questions[-1][0]
        for i in range(n - 2, -1, -1):
            solve, power = questions[i]
            if i + power + 1 < n:
                solve += dp[next]
            dp[i] = max(solve, dp[i + 1])
        return dp[0]