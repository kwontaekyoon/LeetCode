class Solution:
    def assignEdgeWeights(self, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(len(edges) + 2)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        max_depth = 0
        stack = [(1, 0, 0)]
        while stack:
            curr, prev, curr_depth = stack.pop()
            max_depth = max(curr_depth, max_depth)
            for next in graph[curr]:
                if next != prev:
                    stack.append((next, curr, curr_depth + 1))
        return pow(2, max_depth - 1, 1000000007)
