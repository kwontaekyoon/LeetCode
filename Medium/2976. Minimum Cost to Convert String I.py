from cmath import inf
from typing import List


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        min_dists = [[inf] * 26 for _ in range(26)]
        for i in range(26):
            min_dists[i][i] = 0
        for s, t, c in zip(original, changed, cost):
            u = ord(s) - 97
            v = ord(t) - 97
            min_dists[u][v] = min(min_dists[u][v], c)
        for y in range(26):
            for x in range(26):
                if min_dists[x][y] == inf:
                    continue
                for z in range(26):
                    if min_dists[y][z] == inf:
                        continue
                    min_dists[x][z] = min(min_dists[x][z], min_dists[x][y] + min_dists[y][z])
        total_costs = 0
        for s, t in zip(source, target):
            if s == t:
                continue
            u = ord(s) - 97
            v = ord(t) - 97
            if min_dists[u][v] == inf:
                return -1
            total_costs += min_dists[u][v]
        return total_costs # type: ignore
        
