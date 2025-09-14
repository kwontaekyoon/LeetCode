from collections import Counter


VOWELS = { 'a', 'e', 'i', 'o', 'u' }

class Solution:
    def maxFreqSum(self, s: str) -> int:
        vowel = consonant = 0
        for c, freq in Counter(s).items():
            if c in VOWELS:
                vowel = max(vowel, freq)
            else:
                consonant = max(consonant, freq)
        return vowel + consonant