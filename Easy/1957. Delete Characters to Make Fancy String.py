class Solution:
    def makeFancyString(self, s: str) -> str:
        res = []        
        prev = None
        rep = 0
        for c in s:
            if c == prev:
                rep += 1
            else:
                prev = c
                rep = 1
            if rep < 3:
                res.append(c)
        return ''.join(res)

class Solution1:
    def makeFancyString(self, s: str) -> str:
        n = len(s)
        if n < 3:
            return s
        fancy = s[:2]
        for i in range(2, n):
            if fancy[-1] == fancy[-2] and fancy[-1] == s[i]:
                continue
            fancy += s[i]
        return fancy