from typing import List


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        parents = list(range(len(edges) + 1))
        def find(child: int) -> int:
            if parents[child] != child:
                parents[child] = find(parents[child])
            return parents[child]
        def union(node1: int, node2: int) -> bool:
            parent1, parent2 = find(node1), find(node2)
            if parent1 == parent2:
                return False
            parents[parent1] = parent2
            return True
        for u, v in edges:
            if not union(u, v):
                return [u, v]