from collections import defaultdict, deque
from typing import List


class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        if n < 2:
            return 1
        graph = defaultdict(list)
        degree = [0] * n
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
            degree[a] += 1
            degree[b] += 1
        node_vals = values[:]
        leaf_q = deque([i for i in range(n) if degree[i] == 1])
        comp_cnt = 0
        while leaf_q:
            curr = leaf_q.popleft()
            degree[curr] -= 1
            carry = 0
            if node_vals[curr] % k == 0:
                comp_cnt += 1
            else:
                carry = node_vals[curr]
            for next in graph[curr]:
                if degree[next] == 0:
                    continue
                degree[next] -= 1
                node_vals[next] += carry
                if degree[next] == 1:
                    leaf_q.append(next)
        return comp_cnt