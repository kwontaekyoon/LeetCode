from collections import deque
from typing import List


class Solution:
    def countMentions(self, n: int, events: List[List[str]]) -> List[int]:
        mentions = [0] * n
        back = [0] * n
        events.sort(key=lambda e: (int(e[1]), e[0]=="MESSAGE"))

        for typ, t, data in events:
            t = int(t)
            if typ == "OFFLINE":
                back[int(data)] = t + 60
                continue

            for tok in data.split():
                if tok == "ALL":
                    for u in range(n):
                        mentions[u] += 1
                elif tok == "HERE":
                    for u in range(n):
                        if t >= back[u]:
                            mentions[u] += 1
                else:  
                    mentions[int(tok[2:])] += 1

        return mentions

class Solution1:
    def countMentions(self, n: int, events: List[List[str]]) -> List[int]:
        events.sort(key=lambda event: (int(event[1]), event[0]=="MESSAGE"))
        count_mentions = [0] * n
        online_users = [True] * n
        offline_queue = deque([])
        for command, timestamp, mentions in events:
            timestamp = int(timestamp)
            while offline_queue and offline_queue[0][0] <= timestamp:
                online_users[offline_queue.popleft()[1]] = True
            if command == "MESSAGE":
                if mentions == "ALL":
                    for id in range(n):
                        count_mentions[id] += 1
                elif mentions == "HERE":
                    for id, is_online in enumerate(online_users):
                        if is_online:
                            count_mentions[id] += 1
                else:
                    for id in (int(id[2:]) for id in list(mentions.split())):
                        count_mentions[id] += 1
            else:
                id = int(mentions)
                online_users[id] = False
                offline_queue.append((timestamp + 60, id))
        return count_mentions