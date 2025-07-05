from collections import Counter
from typing import List


class Solution:
    def findLucky(self, arr: List[int]) -> int:
        result = -1
        for k, v in Counter(arr).items():
            if k == v:
                result = max(result, k)
        return result