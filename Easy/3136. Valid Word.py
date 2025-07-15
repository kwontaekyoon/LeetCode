VOWELS = 'aeiouAEIOU'
class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3:
            return False
        v = c = False
        for char in word:
            if char.isalpha():
                if char in VOWELS:
                    v = True
                else:
                    c = True
            elif not char.isdigit():
                return False
        return v and c