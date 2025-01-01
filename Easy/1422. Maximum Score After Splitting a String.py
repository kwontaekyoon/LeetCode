class Solution:
    def maxScore(self, s: str) -> int:
        curr_score, max_score = s.count('1'), 0
        for i in range(len(s) - 1):
            curr_score += 1 if s[i] == '0' else -1
            max_score = max(curr_score, max_score)
        return max_score