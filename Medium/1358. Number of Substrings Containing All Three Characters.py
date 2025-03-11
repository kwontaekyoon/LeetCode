from collections import defaultdict


class Greedy:
    def numberOfSubstrings(self, s: str) -> int:
        pos = [-1, -1, -1]
        res = 0
        for i, c in enumerate(s):
            pos[ord(c) - ord('a')] = i
            res += min(pos) + 1
        return res

class HashTable:
    def numberOfSubstrings(self, s: str) -> int:
        cnt = defaultdict(int)
        l, n, res = 0, len(s), 0
        for r in range(n):
            cnt[s[r]] += 1
            while cnt['a'] and cnt['b'] and cnt['c']:
                res += n - r
                cnt[s[l]] -= 1
                l += 1
        return res