class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        if len(s) < k:
            return False
        # Counter is faster in theory, but has higher fixed overhead, especially compared to str.count, which can scan the underlying C array with direct memory comparisons
        for c in set(s):
            k -= s.count(c) % 2
        # for v in Counter(s).values():
        #     k -= v % 2
        return k >= 0