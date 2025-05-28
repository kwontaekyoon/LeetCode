from typing import List


class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:
        def build(edges: List[List[int]]) -> List[List[int]]:
            n = len(edges) + 1
            graph = [[] for _ in range(n)]
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)
            return graph
        def dfs(graph: List[List[int]], u: int, p: int, k: int) -> int:
            if k < 0:
                return 0
            cnt = 1
            for v in graph[u]:
                if v != p:
                    cnt += dfs(graph, v, u, k - 1)
            return cnt
        graph2 = build(edges2)
        maxiB = 0
        for i in range(len(graph2)):
            maxiB = max(dfs(graph2, i, -1, k - 1), maxiB)
        result = []
        graph1 = build(edges1)
        for i in range(len(graph1)):
            result.append(dfs(graph1, i, -1, k) + maxiB)
        return result