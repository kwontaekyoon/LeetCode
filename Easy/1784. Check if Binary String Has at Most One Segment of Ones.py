class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        return '01' not in s

class Solution1:
    def checkOnesSegment(self, s: str) -> bool:
        zero = False
        for c in s[1:]:
            if c == '0':
                zero = True
            else:
                if zero:
                    return False
        return True