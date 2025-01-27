from collections import defaultdict, deque
from typing import List


class Solution1BFS:
    def checkIfPrerequisite(self, N: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        graph = defaultdict(list)
        for prev, next in prerequisites:
            graph[prev].append(next)
        reachable = [[False] * N for _ in range(N)]
        for origin in range(N):
            queue = deque([origin])
            while queue:
                curr = queue.popleft()
                for next in graph[curr]:
                    if reachable[origin][next]:
                        continue
                    reachable[origin][next] = True
                    queue.append(next)
        return [reachable[u][v] for u, v in queries]
