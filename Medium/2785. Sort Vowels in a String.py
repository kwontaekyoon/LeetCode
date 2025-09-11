VOWELS = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' }
class Solution:
    def sortVowels(self, s: str) -> str:
        chars = list(s)
        vowels = []
        indexs = []
        for i, v in enumerate(chars):
            if v in VOWELS:
                vowels.append(v)
                indexs.append(i)
        vowels.sort()
        for i, v in zip(indexs, vowels):
            chars[i] = v
        return ''.join(chars)