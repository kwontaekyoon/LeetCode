from collections import Counter
from functools import cache
from math import comb


class Solution:
    def countBalancedPermutations(self, num: str) -> int:
        total = sum(int(c) for c in num)
        if total % 2:
            return 0
        cnt = Counter(int(c) for c in num)
        @cache
        def dfs(i, odd, even, balance):
            if odd == 0 and even == 0 and balance == 0:
                return 1
            if i < 0 or odd < 0 or even < 0 or balance < 0:
                return 0
            res = 0
            for j in range(0, cnt[i] + 1):
                res += comb(odd, j) * comb(even, cnt[i] - j) * dfs(i - 1, odd - j, even - cnt[i] + j, balance - i * j)
            return res % 1000000007
        return dfs(9, len(num) - len(num) // 2, len(num) // 2, total // 2)