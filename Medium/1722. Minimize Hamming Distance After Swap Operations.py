class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        n = len(source)
        parents = list(range(n))

        def find(x: int) -> int:
            if parents[x] != x:
                parents[x] = find(parents[x])
            return parents[x]
        
        def unite(a: int, b: int) -> None:
            parents[find(a)] = find(b)
        
        for a, b in allowedSwaps:
            unite(a, b)
        
        groups = defaultdict(list)
        for i in range(n):
            groups[find(i)].append(source[i])
        groups = {root: Counter(vals) for root, vals in groups.items()}

        dist = 0
        for i in range(n):
            root = find(i)
            freq = groups[root]
            if freq[target[i]] > 0:
                freq[target[i]] -= 1
            else:
                dist += 1
        return dist
