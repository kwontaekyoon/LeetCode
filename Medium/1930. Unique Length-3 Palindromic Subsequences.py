from collections import defaultdict


class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        first_and_last = defaultdict(list)
        for i in range(len(s)):
            if len(first_and_last[s[i]]) > 1:
                first_and_last[s[i]][-1] = i
            else:
                first_and_last[s[i]].append(i)
        res = 0
        for k, v in first_and_last.items():
            if len(v) < 2:
                continue
            res += len(set(s[v[0]+1:v[1]]))
        return res