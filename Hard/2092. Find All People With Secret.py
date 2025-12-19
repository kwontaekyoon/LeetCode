from collections import defaultdict
from typing import List


class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], first_person: int) -> List[int]:
        people_with_secret = [False] * n
        people_with_secret[0] = people_with_secret[first_person] = True
        time_meetings = defaultdict(list)
        for u, v, t in meetings:
            time_meetings[t].append((u, v))
        for t in sorted(time_meetings.keys()):
            curr_meetings = time_meetings[t]
            graph = defaultdict(list)
            bfs = set()
            for u, v in curr_meetings:
                graph[u].append(v)
                graph[v].append(u)
                if people_with_secret[u]:
                    bfs.add(u)
                if people_with_secret[v]:
                    bfs.add(v)
            bfs = list(bfs)
            while bfs:
                sharer = bfs.pop()
                for sharee in graph[sharer]:
                    if not people_with_secret[sharee]:
                        bfs.append(sharee)
                        people_with_secret[sharee] = True
        return [i for i, v in enumerate(people_with_secret) if v]