class Solution:
    def binaryGap(self, n: int) -> int:
        res = prev = 0
        for i, bit in enumerate(bin(n)[2:]):
            if bit == '1':
                res = max(res, i - prev)
                prev = i
        return res