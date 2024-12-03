from typing import List


class Optimized:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        index = 0
        res = []
        for space in spaces:
            res.append(s[index:space])
            index = space
        res.append(s[index:])
        return " ".join(res)

class BF:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        res = ""
        n = len(spaces)
        j = 0
        for i in range(len(s)):
            if j == n:
                res += s[i:]
                break
            if spaces[j] == i:
                res += " " + s[i]
                j += 1
            else:
                res += s[i]
        return res