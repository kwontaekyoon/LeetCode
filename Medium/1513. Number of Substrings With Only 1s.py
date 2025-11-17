class Solution:
    def numSub(self, s: str) -> int:
        result = ones = 0
        for c in s:
            if c == '1':
                ones += 1
                result += ones
            else:
                ones = 0
        return result % 1000000007

class Solution1:
    def numSub(self, s: str) -> int:
        return sum(n * (n + 1) // 2 for n in [len(c) for c in s.split('0')]) % 1000000007