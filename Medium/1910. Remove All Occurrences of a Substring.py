class Solution1:
    def removeOccurrences(self, s: str, part: str) -> str:
        while part in s:
            s = s.replace(part, '', 1)
        return s

class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        i = 0
        while i < len(s):
            j = i
            if s[j:j + len(part)] == part:
                s = s[:j] + s[j + len(part):]
                i -= len(part) + 1
            else:
                i += 1
        return s