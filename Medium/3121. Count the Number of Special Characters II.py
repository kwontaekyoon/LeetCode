class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        hm = [0] * 26
        for c in word:
            i = ord(c)
            # lower
            if i > 96:
                i -= 97
                if hm[i] == 0:
                    hm[i] = 1
                elif hm[i] == 2:
                    hm[i] = 3
            # upper
            else:
                i -= 65
                if hm[i] == 0:
                    hm[i] = 3
                elif hm[i] == 1:
                    hm[i] = 2
        return hm.count(2)
