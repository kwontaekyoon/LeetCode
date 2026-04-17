class Solution:
    def minMirrorPairDistance(self, nums: List[int]) -> int:
        min_dist = len(nums)
        hm = {}
        for i, v in enumerate(nums):
            if v in hm:
                min_dist = min(i - hm[v], min_dist)
            hm[int(str(v)[::-1])] = i
        return -1 if min_dist == len(nums) else min_dist
