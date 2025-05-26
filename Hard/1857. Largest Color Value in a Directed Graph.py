from collections import defaultdict
from typing import List


class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]):
        n = len(colors)
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
        count = [[0] * 26 for _ in range(n)]
        visited = [0] * n
        def dfs(node: int):
            if visited[node] == 1:
                return float('inf')
            if visited[node] == 2:
                return count[node][ord(colors[node]) - ord('a')]
            visited[node] = 1
            for next in graph[node]:
                res = dfs(next)
                if res == float('inf'):
                    return float('inf')
                for c in range(26):
                    count[node][c] = max(count[node][c], count[next][c])
            color = ord(colors[node]) - ord('a')
            count[node][color] += 1
            visited[node] = 2
            return count[node][color]
        result = 0
        for i in range(n):
            val = dfs(i)
            if val == float('inf'):
                return -1
            result = max(val, result)
        return result