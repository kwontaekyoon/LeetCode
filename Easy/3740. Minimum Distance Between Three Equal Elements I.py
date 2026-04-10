class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        num_to_idxs = defaultdict(list)
        for i, v in enumerate(nums):
            num_to_idxs[v].append(i)
        min_dist = float('inf')
        for li in num_to_idxs.values():
            if len(li) < 3:
                continue
            for i in range(1, len(li) - 1):
                min_dist = min(abs(li[i] - li[i - 1]) + abs(li[i - 1] - li[i + 1]) + abs(li[i] - li[i + 1]), min_dist)
        return -1 if min_dist == float('inf') else min_dist
