from math import gcd, sqrt


class Solution:
    def countTriples(self, n: int) -> int:
        res = 0
        for u in range(2, int(sqrt(n)) + 1):
            for v in range(1, u):
                if (u - v) & 1 == 0 or gcd(u, v) != 1:
                    continue                    
                c = u * u + v * v
                if c > n:
                    continue
                res += 2 * (n // c)
        return res


class Solution1:
    def countTriples(self, n: int) -> int:
        squares = [i ** 2 for i in range(1, n + 1)][::-1]
        squares_set = set(squares)
        count = 0
        for i, c_square in enumerate(squares):
            for a_square in squares[i + 1:]:
                if c_square - a_square in squares_set:
                    count += 1
        return count