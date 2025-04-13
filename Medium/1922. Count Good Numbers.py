class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        # result is 5 ^ even * 4 ^ odd
        even, odd = (n + 1) // 2, n // 2
        def power(base: int, exp: int) -> int:
            result = 1
            while exp:
                if exp % 2:
                    result = (result * base) % MOD
                base = (base * base) % MOD
                exp //= 2
            return result
        # return (power(5, even) * power(4, odd)) % MOD
        def recursion(base: int, exp: int) -> int:
            if not exp:
                return 1
            if exp % 2:
                return base * recursion(base, exp - 1) % MOD
            else:
                return recursion(base * base % MOD, exp // 2)
        return recursion(20, n // 2) * (5 ** (n % 2)) % MOD
