from typing import List


class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        nums_idxs = [(v, i) for i, v in enumerate(nums)]
        top_k = sorted(nums_idxs, key = lambda x: -x[0])[:k]
        return [num for num, _ in sorted(top_k, key = lambda x: x[1])]