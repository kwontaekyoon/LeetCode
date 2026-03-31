class Solution:
    def generateString(self, s: str, t: str) -> str:
        n, m = len(s), len(t)
        res = ['?'] * (n + m - 1)
        for i, b in enumerate(s):
            if b != 'T':
                continue
            for j, c in enumerate(t):
                v = res[i + j]
                if v != '?' and v != c:
                    return ""
                res[i + j] = c
        old_res = res
        res = ['a' if c == '?' else c for c in res]
        for i, b in enumerate(s):
            if b != 'F':
                continue
            if ''.join(res[i:i+m]) != t:
                continue
            for j in range(i + m - 1, i - 1, -1):
                if old_res[j] == '?':
                    res[j] = 'b'
                    break
            else:
                return ''
        return ''.join(res)
