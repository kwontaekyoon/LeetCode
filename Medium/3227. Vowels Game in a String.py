VOWELS = { 'a', 'e', 'i', 'o', 'u' }
class Solution:
    def doesAliceWin(self, s: str) -> bool:
        for c in s:
            if c in VOWELS:
                return True
        return False