from collections import Counter
from typing import List


class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        ans = set(words1)
        letters = {}
        for i in words2:
            for j in i:
                count = i.count(j)
                if j not in letters or count > letters[j]:
                    letters[j] = count
        for i in words1:
            for j in letters:
                if i.count(j) < letters[j]:
                    ans.remove(i)
                    break
        return list(ans)

class OptimizedWithCounter:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        res = set(words1)
        subs = Counter()
        for word in words2:
            for k, v in Counter(word).items():
                subs[k] = max(v, subs[k])
        for word in words1:
            for k, v in subs.items():
                if word.count(k) < v:
                    res.remove(word)
                    break
        return list(res)

class FreqCount:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        freqs = [0] * 26
        for word in words2:
            temps = [0] * 26
            for c in word:
                temps[ord(c) - ord('a')] += 1
            for i in range(26):
                freqs[i] = max(temps[i], freqs[i])
        res = []
        for word in words1:
            temps = [0] * 26
            for c in word:
                temps[ord(c) - ord('a')] += 1
            issub = True
            for i in range(26):
                if temps[i] < freqs[i]:
                    issub = False
                    break
            if issub:
                res.append(word)
        return res