from collections import defaultdict
import string


class UnionFind:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        parents = {x: x for x in string.ascii_lowercase}
        sets = {x: set([x]) for x in string.ascii_lowercase}

        def union(a, b):
            if a == b:
                return

            ap = parents[a]
            bp = parents[b]

            if bp < ap:
                ap, bp = bp, ap

            for c in sets[bp]:
                parents[c] = ap
                sets[ap].add(c)

        for a, b in zip(s1, s2):
            union(a, b)

        return ''.join(parents[x] for x in baseStr)

class DFS:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        graph = defaultdict(list)
        for u, v in zip(s1, s2):
            graph[u].append(v)
            graph[v].append(u)
        def dfs(c: str, visited: set) -> str:
            visited.add(c)
            min_c = c
            for next in graph[c]:
                if next not in visited:
                    min_c = min(dfs(next, visited), min_c)
            return min_c
        result = []
        for c in baseStr:
            result.append(dfs(c, set()))
        return ''.join(result)
