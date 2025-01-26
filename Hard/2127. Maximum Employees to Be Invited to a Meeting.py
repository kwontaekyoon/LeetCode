from collections import deque
from typing import List


class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        N = len(favorite)
        indegree = [0] * N
        chain_lengths = [0] * N
        visited = [False] * N
        for fav in favorite:
            indegree[fav] += 1
        queue = deque()
        for i in range(N):
            if indegree[i] == 0:
                queue.append(i)
        while queue:
            curr = queue.popleft()
            visited[curr] = True
            next = favorite[curr]
            chain_lengths[next] = chain_lengths[curr] + 1
            indegree[next] -= 1
            if indegree[next] == 0:
                queue.append(next)
        max_cycle, total_chains = 0, 0
        for i in range(N):
            if not visited[i]:
                curr, cycle_length = i, 0
                while not visited[curr]:
                    visited[curr] = True
                    curr = favorite[curr]
                    cycle_length += 1
                if cycle_length == 2:
                    total_chains += 2 + chain_lengths[i] + chain_lengths[favorite[i]]
                else:
                    max_cycle = max(max_cycle, cycle_length)
        return max(max_cycle, total_chains)