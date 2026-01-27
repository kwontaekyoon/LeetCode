import heapq
from typing import List


class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]
        for u, v, w in edges:
            graph[u].append((w, v))
            graph[v].append((w * 2, u))
        fastest_way = [float('inf')] * n
        heap = [(0, 0)]
        while heap:
            curr_w, curr_node = heapq.heappop(heap)
            if curr_node == n - 1:
                return curr_w
            if fastest_way[curr_node] <= curr_w:
                continue
            fastest_way[curr_node] = curr_w
            for next_w, next_node in graph[curr_node]:
                heapq.heappush(heap, (curr_w + next_w, next_node))
        return -1