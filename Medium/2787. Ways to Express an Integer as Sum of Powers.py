from typing import Counter


class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        dp = [1] + [0] * n
        for num in range(1, n + 1):
            power = num ** x
            if power > n:
                break
            for target in range(n, power - 1, -1):
                dp[target] += dp[target - power]
        return dp[n] % (10 ** 9 + 7)

class HashTable:
    def numberOfWays(self, n: int, x: int) -> int:
        count = Counter({0: 1})
        i = 1
        while i ** x <= n:
            power = i ** x
            new_count = Counter() 
            for k, v in count.items():
                if k + power <= n:
                    new_count[k + i ** x] += v
            count.update(new_count)
            i += 1
        return count[n] % (10 ** 9 + 7)