class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        dp = [0] * (n + 1)
        dp[1] = 1
        share = 0
        for day in range(2, n + 1):
            if day - delay > 0:
                share += dp[day - delay]
            if day - forget > 0:
                share -= dp[day - forget]
            dp[day] = share
        return sum(dp[n - forget + 1:]) % (10 ** 9 + 7)