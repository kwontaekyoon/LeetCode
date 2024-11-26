from collections import deque
from typing import List


class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        can_win = [True] * n
        for u, v in edges:
            can_win[v] = False
        winner = -1
        winner_cnt = 0
        for i, can in enumerate(can_win):
            if can:
                winner = i
                winner_cnt += 1
        return winner if winner_cnt == 1 else -1

class DFS:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        graph = {i:[] for i in range(n)}
        degrees = [0] * n
        for u, v in edges:
            graph[u].append(v)
            degrees[v] += 1
        for i in range(n):
            if degrees[i] == 0:
                stack = deque([i])
                visited = [False] * n
                visited[i] = True
                cnt = 1
                while stack:
                    curr = stack.pop()
                    for next in graph[curr]:
                        if not visited[next]:
                            stack.append(next)
                            visited[next] = True
                            cnt += 1
                if cnt == n:
                    return i
        return -1