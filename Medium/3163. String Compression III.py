class Solution:
    def compressedString(self, word: str) -> str:
        rep = 0
        prev = None
        res = ""
        for curr in word:
            if curr == prev:
                rep += 1
                if rep > 9:
                    res += str(9)    
                    res += curr
                    rep = 1
            else:
                if prev:
                    res += str(rep)
                    res += prev
                rep = 1
                prev = curr
        res += str(rep)
        res += prev
        return res