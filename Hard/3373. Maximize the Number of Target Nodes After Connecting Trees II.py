from typing import List


class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]]) -> List[int]:
        def build(edges: List[List[int]]) -> List[List[int]]:
            graph = [[] for _ in range(len(edges) + 1)]
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)
            return graph
        def dfs(graph: List[List[int]], u: int, parent: int, color: List[int], isA: bool) -> None:
            nonlocal evenA, evenB, oddA, oddB
            if color[u] == 0:
                if isA:
                    evenA += 1
                else:
                    evenB += 1
            else:
                if isA:
                    oddA += 1
                else:
                    oddB += 1
            for v in graph[u]:
                if v != parent:
                    color[v] = color[u] ^ 1
                    dfs(graph, v, u, color, isA)
        graphA = build(edges1)
        graphB = build(edges2)
        n, m = len(graphA), len(graphB)
        colorA = [-1] * n
        colorB = [-1] * m
        evenA = oddA = evenB = oddB = 0
        colorA[0] = 0
        dfs(graphA, 0, -1, colorA, True)
        colorB[0] = 0
        dfs(graphB, 0, -1, colorB, False)
        maxiB = max(evenB, oddB)
        result = [0] * n
        for i in range(n):
            result[i] = (evenA if not colorA[i] else oddA) + maxiB
        return result