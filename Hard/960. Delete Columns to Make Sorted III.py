from typing import List


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        R, C = len(strs), len(strs[0])
        dp = [1] * C
        for curr_c in range(C):
            for prev_c in range(curr_c):
                valid = True
                for r in range(R):
                    if strs[r][prev_c] > strs[r][curr_c]:
                        valid = False
                        break
                if valid:
                    dp[curr_c] = max(dp[curr_c], dp[prev_c] + 1)
        return C - max(dp)