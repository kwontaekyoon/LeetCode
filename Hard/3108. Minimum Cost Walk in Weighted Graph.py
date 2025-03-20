from typing import List


class Solution:
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:
        parents = [i for i in range(n)]
        min_path_cost = [-1 for _ in range(n)]
        def find_root(node: int) -> int:
            if parents[node] != node:
                parents[node] = find_root(parents[node])
            return parents[node]
        for u, v, w in edges:
            u_root = find_root(u)
            v_root = find_root(v)
            min_path_cost[v_root] &= w
            if u_root != v_root:
                min_path_cost[v_root] &= min_path_cost[u_root]
                parents[u_root] = v_root
        res = []
        for start, end in query:
            if start == end:
                res.append(0)
            elif find_root(start) != find_root(end):
                res.append(-1)
            else:
                res.append(min_path_cost[find_root(start)])
        return res