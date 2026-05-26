class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        res = [0] * 26
        seen_upper, seen_lower = [False] * 26, [False] * 26
        for c in word:
            i = ord(c)
            if i > 96:
                i -= 97
                if not seen_lower[i]:
                    res[i] += 1
                    seen_lower[i] = True
            else:
                i -= 65
                if not seen_upper[i]:
                    res[i] += 1
                    seen_upper[i] = True
        return res.count(2)
