class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        def waviness(s: str) -> int:
            cnt = 0
            for i in range(1, len(s) - 1):
                if ((s[i] > s[i - 1] and s[i] > s[i + 1]) or
                   (s[i] < s[i - 1] and s[i] < s[i + 1])):
                    cnt += 1
            return cnt
        return sum(waviness(str(num)) for num in range(num1, num2 + 1))
