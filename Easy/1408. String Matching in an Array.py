from typing import List


class Optimized:
    def stringMatching(self, words: List[str]) -> List[str]:
        return [w for w in words if ' '.join(words).count(w) > 1]

class BF:
    def stringMatching(self, words: List[str]) -> List[str]:
        n = len(words)
        subs = []
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                if words[j].find(words[i]) != -1:
                    subs.append(words[i])
                    break
        return subs