from collections import defaultdict, deque
from typing import List


class OptimizedBFS:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        for i in range(n - 1):
            graph[i].append(i + 1)
        dists = [i for i in range(n)]
        res = []
        for u, v in queries:
            graph[u].append(v)
            if dists[v] > dists[u] + 1:
                dists[v] = dists[u] + 1
                queue = deque([v])
                while queue:
                    curr_pos = queue.popleft()
                    for next_pos in graph[curr_pos]:
                        if dists[next_pos] > dists[curr_pos] + 1:
                            dists[next_pos] = dists[curr_pos] + 1
                            queue.append(next_pos)
            res.append(dists[-1])
        return res


class BFS:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        graph = {i:[i+1] for i in range(n - 1)}
        res = []
        for u, v in queries:
            graph[u].append(v)
            queue = deque([0])
            visit = [False] * n
            moves = 0
            while queue:
                size = len(queue)
                for _ in range(size):
                    curr_pos = queue.popleft()
                    if curr_pos == n - 1:
                        res.append(moves)
                        queue.clear()
                        break
                    for next_pos in graph[curr_pos]:
                        if visit[next_pos]:
                            continue
                        queue.append(next_pos)
                        visit[next_pos] = True
                moves += 1
        return res