from typing import List


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        INF = 10 ** 30
        id = {}
        lens = set()
        sz = 0
        dist = [[INF] * 201 for _ in range(201)]
        for s, t, c in zip(original, changed, cost):
            if s not in id:
                id[s] = sz
                lens.add(len(s))
                sz += 1
            if t not in id:
                id[t] = sz
                sz += 1
            dist[id[s]][id[t]] = min(dist[id[s]][id[t]], c)
        for i in range(sz):
            dist[i][i] = 0
        for y in range(sz):
            for x in range(sz):
                if dist[x][y] == INF:
                    continue
                for z in range(sz):
                    if dist[y][z] == INF:
                        continue
                    dist[x][z] = min(dist[x][z], dist[x][y] + dist[y][z])
        n = len(source)
        dp = [0] + [INF] * n
        for i in range(n):
            if dp[i] == INF:
                continue
            if source[i] == target[i]:
                dp[i + 1] = min(dp[i + 1], dp[i])
            for l in lens:
                if i + l > n:
                    continue
                s = source[i:i + l]
                t = target[i:i + l]
                if s in id and t in id:
                    dp[i + l] = min(dp[i + l], dp[i] + dist[id[s]][id[t]])
        return -1 if dp[n] == INF else dp[n]
