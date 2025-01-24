from collections import deque
from typing import List


class OptimizedRecursion:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        visited = [False] * n
        path_visited = [False] * n
        safe_nodes = []

        def dfs(cur_node: int) -> bool:
            # Mark the current node as visited and part of the current path
            visited[cur_node] = True
            path_visited[cur_node] = True
        
            for neighbor in graph[cur_node]:
                if not visited[neighbor]:
                    if dfs(neighbor):
                        return True
                elif path_visited[neighbor]:  # Cycle detected
                    return True

            # If no cycle is found, the node is safe
            path_visited[cur_node] = False
            safe_nodes.append(cur_node)
            return False

        for i in range(n):
            if not visited[i]:
                dfs(i)

        # Return all safe nodes sorted in ascending order
        return sorted(safe_nodes)


class Solution1:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        N = len(graph)
        degree_in = [0] * N
        rgraph = [[] for _ in range(N)]
        for u in range(N):
            for v in graph[u]:
                rgraph[v].append(u)
                degree_in[u] += 1
        queue = deque()
        for i in range(N):
            if degree_in[i] == 0:
                queue.append(i)
        ans = []
        while queue:
            u = queue.popleft()
            ans.append(u)
            for v in rgraph[u]:
                degree_in[v] -= 1
                if degree_in[v] == 0:
                    queue.append(v)
        return sorted(ans)
