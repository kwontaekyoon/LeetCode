import math


class Solution:
    def minOperations(self, s: str, k: int) -> int:
        z = s.count('0')
        n = len(s)
        if z == 0:
            return 0
        if n == k:
            return 1 if z == n else -1
        base = n - k
        odd = max(math.ceil(z / k), math.ceil((n - z) / base))
        odd += ~odd & 1
        even = max(math.ceil(z / k), math.ceil(z / base))
        even += even & 1
        res = float('inf')
        if (k & 1) == (z & 1):
            res = min(res, odd)
        if (~z & 1) == 1:
            res = min(res, even)
        return -1 if res == float('inf') else int(res)
            
