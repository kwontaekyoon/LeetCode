from collections import Counter


class Solution:
    def maxDifference(self, s: str) -> int:
        max_odd = 1
        min_even = 100
        for v in Counter(s).values():
            if v % 2:
                max_odd = max(v, max_odd)
            else:
                min_even = min(v, min_even)
        return max_odd - min_even