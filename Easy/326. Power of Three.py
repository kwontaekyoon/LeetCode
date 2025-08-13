from math import log

class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        while n % 3 == 0:
            n //= 3
        return n == 1

class Logarithms:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        # return int(log(n, 3)) == log(n, 3)
        return n == 3 ** round(log(n, 3))