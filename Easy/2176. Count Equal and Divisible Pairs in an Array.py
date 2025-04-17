from collections import defaultdict
from typing import List


class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        result = 0
        mapp = defaultdict(list)
        for i, v in enumerate(nums):
            for pi in mapp[v]:
                if (pi * i) % k == 0:
                    result += 1
            mapp[v].append(i)
        return result