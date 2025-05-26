from collections import Counter, defaultdict
from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        counter = Counter(words)
        result = 0
        used_mid = False
        for word in counter:
            if word == word[::-1]:
                pairs = counter[word]//2
                result += pairs * 4
                if counter[word] % 2 == 1:
                    used_mid = True
            elif word[0] < word[1]:
                rev = word[::-1]
                pairs = min(counter[word], counter[rev])
                result += pairs * 4
        if used_mid:
            result += 2
        return result

class Solution1:
    def longestPalindrome(self, words: List[str]) -> int:
        result = 0
        hashmap = defaultdict(int)
        for word in words:
            reverse = word[::-1]
            if reverse in hashmap:
                result += 4
                hashmap[reverse] -= 1
                if hashmap[reverse] == 0:
                    del hashmap[reverse]
            else:
                hashmap[word] += 1
        found = False
        for i in range(26):
            if chr(ord('a') + i) * 2 in hashmap:
                found = True
                break
        if result and found:
            return result + 2
        if not result and found:
            return 2
        return result