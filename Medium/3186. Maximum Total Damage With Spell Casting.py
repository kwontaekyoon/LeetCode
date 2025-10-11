from collections import Counter
from typing import List


class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        counter = Counter(power)
        keys = sorted(counter)
        dp = [0] * len(keys)
        dp[0] = keys[0] * counter[keys[0]]
        for i in range(1, len(keys)):
            take = counter[keys[i]] * keys[i]
            j = i - 1
            while j >= 0 and keys[i] - keys[j] < 3:
                j -= 1
            if j >= 0:
                take += dp[j]
            dp[i] = max(dp[i - 1], take)
        return dp[-1]

class Solution2:
    def maximumTotalDamage(self, power: List[int]) -> int:
        count = Counter(power)
        strength = {k: k * count[k] for k in count}
        spells = [0, 0, 0] + sorted(list(strength.keys()))
        n = len(spells)
        dp = [0] * n
        for i in range(3, n):
            if spells[i] - spells[i-1] > 2:
                dp[i] = dp[i - 1] + strength[spells[i]]
            elif spells[i] - spells[i - 2] > 2:
                dp[i] = max(dp[i - 1], dp[i - 2] + strength[spells[i]])
            else:
                dp[i] = max(dp[i - 1], dp[i - 3] + strength[spells[i]])
        return dp[-1]