class Solution:
    def concatenatedBinary(self, n: int) -> int:
        res = 0
        for i in range(1, n + 1):
            res = ((res << i.bit_length()) + i) % 1000000007
        return res

class Solution1:
    def concatenatedBinary(self, n: int) -> int:
        res = []
        for i in range(1, n + 1):
            res.append(bin(i)[2:])
        return int(''.join(res), 2) % 1000000007