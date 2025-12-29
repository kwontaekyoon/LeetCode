from collections import defaultdict
from typing import List


class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mpp = defaultdict(set)
        for u, v, w in allowed:
            mpp[(u, v)].add(w)
        def add_neighbour(node: str) -> List[str]:
            res = ['']
            for i in range(1, len(node)):
                eles = mpp[(node[i - 1], node[i])]
                if eles:
                    res = [a + e for e in eles for a in res]
                else:
                    return []
            return res
        visited = set()
        def dfs(node: str) -> bool:
            if len(node) == 1:
                return True
            if node in visited:
                return False
            for nxt in add_neighbour(node):
                if dfs(nxt):
                    return True
            visited.add(node)
            return False
        return dfs(bottom)