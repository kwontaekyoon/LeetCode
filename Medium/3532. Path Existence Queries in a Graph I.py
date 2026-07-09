class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        parents = list(range(n))
        for i in range(n - 1):
            if nums[i + 1] - nums[i] <= maxDiff:
                parents[i + 1] = parents[i]
        return [parents[u] == parents[v] for u, v in queries]
