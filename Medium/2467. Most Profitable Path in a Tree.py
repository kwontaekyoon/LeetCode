from collections import defaultdict
from math import inf
from typing import List


class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        n = len(amount)
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        bob_time = [n] * n
        def dfs_bob(node: int, parent: int, time: int) -> bool:
            if node == 0:
                bob_time[node] = time
                return True
            for neighbour in graph[node]:
                if neighbour != parent and dfs_bob(neighbour, node, time + 1):
                    bob_time[node] = time
                    return True
            return False
        dfs_bob(bob, -1, 0)

        graph[0].append(-1)
        ans = -inf
        def dfs_alice(node: int, parent: int, time: int, profit: int) -> None:
            if time < bob_time[node]:
                profit += amount[node]
            elif time == bob_time[node]:
                profit += amount[node] // 2
            if len(graph[node]) == 1:
                nonlocal ans
                ans = max(ans, profit)
                return
            for y in graph[node]:
                if y != parent:
                    dfs_alice(y, node, time + 1, profit)
        
        dfs_alice(0, -1, 0, 0)
        return ans