from collections import deque
from typing import List


class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        visited = [False for _ in range(n)]
        result = 0
        def bfs(node: int) -> List[int]:
            queue = deque([node])
            visited[node] = True
            components = [node]
            while queue:
                curr = queue.popleft()
                for next in graph[curr]:
                    if not visited[next]:
                        visited[next] = True
                        queue.append(next)
                        components.append(next)
            return components
        for node in range(n):
            if not visited[node]:
                components = bfs(node)
                if all(len(graph[node]) == len(components) - 1 for node in components):
                    result += 1
        return result