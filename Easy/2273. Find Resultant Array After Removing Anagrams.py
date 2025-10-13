from typing import List


class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        result = [words[0]]
        for word in words[1:]:
            if sorted(result[-1]) != sorted(word):
                result.append(word)
        return result