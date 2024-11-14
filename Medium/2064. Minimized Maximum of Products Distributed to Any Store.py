from typing import List


class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        l, r = 1, max(quantities)
        while l < r:
            m = (l + r) // 2
            if self.can(n, quantities, m):
                l = m + 1
            else:
                r = m
        return l
    
    def can(self, n: int, quantities: List[int], m: int) -> bool:
        for q in quantities:
            n -= (q + m - 1) // m
        return n < 0