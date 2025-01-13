from collections import Counter


class Solution:
    def minimumLength(self, s: str) -> int:
        return sum(1 if v % 2 else 2 for v in Counter(s).values())

class Solution1:
    def minimumLength(self, s: str) -> int:
        res = 0
        for v in Counter(s).values():
            while v > 2:
                v -= 2
            res += v
        return res