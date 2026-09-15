class Solution:
    def maxPalindromes(self, s: str, k: int) -> int:
        n = len(s)
        dp = [0] * (n + 1)
        for i in range(k - 1, n):
            dp[i + 1] = max(dp[i + 1], dp[i])
            for length in (k, k + 1):
                left = i - length + 1
                if left >= 0 and s[left : i + 1] == s[left : i + 1][::-1]:
                    dp[i + 1] = max(dp[i + 1], dp[left] + 1)
        return dp[n]
