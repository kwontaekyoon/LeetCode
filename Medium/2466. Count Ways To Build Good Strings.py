class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        if zero > one:
            return self.countGoodStrings(low, high, one, zero)
        MOD = 10 ** 9 + 7
        dp = [0] * (high + 1)
        dp[0] = 1
        cnt = 0
        for i in range(1, high + 1):
            if i >= zero:
                dp[i] = (dp[i] + dp[i - zero]) % MOD
            if i >= one:
                dp[i] = (dp[i] + dp[i - one]) % MOD
            if i >= low:
                cnt = (cnt + dp[i]) % MOD
        return cnt

