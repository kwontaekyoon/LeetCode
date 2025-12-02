from collections import defaultdict
from typing import List


class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        y_to_xs = defaultdict(int)
        for x, y in points:
            y_to_xs[y] += 1
        combs = []
        for v in y_to_xs.values():
            if v < 2:
                continue
            combs.append((v * (v - 1) // 2))
        sum_combs = sum(combs)
        result = 0
        for comb in combs:
            result += (sum_combs - comb) * comb
        return result // 2 % 1000000007