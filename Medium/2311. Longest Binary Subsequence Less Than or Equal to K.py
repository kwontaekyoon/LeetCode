class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        result = 0
        for v in s[::-1]:
            if v == '0':
                result += 1
            elif 1 << result <= k:
                k -= 1 << result
                result += 1
        return result