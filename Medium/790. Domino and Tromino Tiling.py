class Solution:
    def numTilings(self, n: int) -> int:
        if n <= 2:
            return n
        MOD = 10 ** 9 + 7
        dp = [1, 1, 2]
        for i in range(n - 2):
            dp.append((dp[-1] * 2 + dp[-3]) % MOD)
        return dp[-1]
