from collections import defaultdict
from typing import List


class BF:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        n = len(words)
        cnt = 0
        for i in range(n-1):
            for j in range(i+1, n):
                if words[j].startswith(words[i]) and words[j].endswith(words[i]):
                    cnt += 1
        return cnt

class HashTable:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        subs = defaultdict(int)
        res = 0
        for word in words:
            n = len(word)
            for i in range(1, n+1):
                prefix, suffix = word[:i], word[n-i:]
                if prefix != suffix:
                    continue
                if prefix in subs:
                    res += subs[prefix]
            subs[prefix] += 1
        return res
