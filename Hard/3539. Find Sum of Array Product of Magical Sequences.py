from functools import cache
import math
from typing import List


class Solution:
    def magicalSum(self, total_count: int, target_odd: int, numbers: List[int]) -> int:
        MOD = 10 ** 9 + 7
        @cache
        def dfs(remaining: int, odd_needed: int, index: int, carry: int) -> int:
            if remaining < 0 or odd_needed < 0 or remaining + carry.bit_count() < odd_needed:
                return 0
            if remaining == 0:
                return 1 if odd_needed == carry.bit_count() else 0
            if index >= len(numbers):
                return 0
            result = 0
            for take in range(remaining + 1):
                ways = math.comb(remaining, take) * pow(numbers[index], take, MOD) % MOD
                new_carry = carry + take
                result += ways * dfs(remaining - take, odd_needed - (new_carry % 2), index + 1, new_carry // 2)
                result %= MOD
            return result
        return dfs(total_count, target_odd, 0, 0)