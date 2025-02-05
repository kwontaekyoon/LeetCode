class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        idx = []
        for i in range(len(s1)):
            if s1[i] == s2[i]:
                continue
            idx.append(i)
            if len(idx) > 2:
                return False
        if not idx:
            return True
        if len(idx) == 1:
            return False
        return s1[idx[0]] == s2[idx[-1]] and s1[idx[-1]] == s2[idx[0]]