class Solution:
    def minimumPushes(self, word: str) -> int:
        n = len(word)
        curr = 1
        min_pushes = 0
        while n >= 8:
            min_pushes += curr * 8
            n -= 8
            curr += 1
        return min_pushes + curr * n