from collections import defaultdict, deque
from typing import List


class Solution:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        graph = defaultdict(list)
        degrees = defaultdict(int)
        for start, end in pairs:
            graph[start].append(end)
            degrees[start] += 1
            degrees[end] -= 1
        start = pairs[0][0]
        for node in degrees:
            if degrees[node] == 1:
                start = node
                break
        path = []
        def dfs(curr: int):
            while graph[curr]:
                next = graph[curr].pop()
                dfs(next)
                path.append((curr, next))
        dfs(start)
        return path[::-1]

# Failed, could not deal with duplicates
class Solution1:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        starts = {x[0]:[(x[0], x[1])] for x in pairs}
        ends = {x[1]:[(x[0] ,x[1])] for x in pairs}
        res = deque([pairs[0]])
        used = {tuple(pairs[0])}
        while res[-1][1] in starts and starts[res[-1][1]] not in used:
            res.append(starts[res[-1][1]])
            used.add(res[-1])
        while res[0][0] in ends and ends[res[0][0]] not in used:
            res.appendleft(ends[res[0][0]])
            used.add(res[0])
        return list(res)