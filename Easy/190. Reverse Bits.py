class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        power = 2 ** 31
        for _ in range(32):
            res += power * (n % 2)
            n //= 2
            power //= 2
        return res