from itertools import combinations
from typing import List


class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        self.max_l = 0
        seen = set()
        def findLen(fences: List[int], cal_m: bool) -> None:
            for x, y in combinations(fences, 2):
                l = y - x
                if cal_m:
                    if l > self.max_l and l in seen:
                        self.max_l = l
                else:
                    seen.add(l)
        hz, vz = len(hFences) + 2, len(vFences) + 2
        if hz > vz:
            return self.maximizeSquareArea(n, m, vFences, hFences)
        hFences += [1, m]
        vFences += [1, n]
        findLen(sorted(hFences), False)
        findLen(sorted(vFences), True)
        return -1 if self.max_l == 0 else self.max_l ** 2 % 1000000007