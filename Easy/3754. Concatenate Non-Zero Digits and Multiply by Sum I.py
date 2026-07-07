class Solution:
    def sumAndMultiply(self, n: int) -> int:
        summ = 0
        curr = 0
        for c in str(n):
            summ += int(c)
            if c != '0':
                curr *= 10
                curr += int(c)
        return curr * summ
