from typing import List


class Solution:
    def getWordsInLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        def valid(word1: str, word2: str) -> bool:
            if len(word1) != len(word2):
                return False
            cnt = 0
            for c1, c2 in zip(word1, word2):
                if c1 != c2:
                    cnt += 1
                if cnt > 1:
                    return False
            return True
        n = len(groups)
        dp = [1] * n
        parents = [-1] * n
        maxi = 0
        for i in range(n):
            for j in range(i):
                if groups[i] != groups[j] and valid(words[i], words[j]) and dp[i] < dp[j] + 1:
                    dp[i] = dp[j] + 1
                    parents[i] = j
            if dp[i] > maxi:
                maxi = dp[i]
        result = []
        for i in range(n):
            if dp[i] == maxi:
                while i != -1:
                    result.append(words[i])
                    i = parents[i]
                break
        return result[::-1]