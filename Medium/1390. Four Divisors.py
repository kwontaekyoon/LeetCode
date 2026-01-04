from typing import List


class Solution:
    def sumFourDivisors(self, nums: list[int]) -> int:
        def isPrime(x: int) -> bool:
            if x < 2:
                return False
            for i in range(2, int(x ** 0.5) + 1):
                if x % i == 0:
                    return False
            return True
        def sumOne(n: int) -> int:
            p = round(n ** (1/3))
            if p ** 3 == n and isPrime(p):
                return 1 + p + p*p + p*p*p

            for i in range(2, int(n ** 0.5) + 1):
                if n % i == 0:
                    a, b = i, n // i
                    if a != b and isPrime(a) and isPrime(b):
                        return 1 + a + b + n
                    return -1
            return -1
        res = 0
        for n in nums:
            val = sumOne(n)
            if val != -1:
                res += val
        return res


primes = (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313)
# numbers up to 100000
# root 100000 = 316.xx
class Solution1:
    def sumFourDivisors(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            if num in primes:
                continue
            first = second = -1
            for prime in primes:
                if prime ** 2 == num or prime >= num:
                    break
                if num % prime == 0:
                    if first == second == -1:
                        first, second = prime, num // prime
                    else:
                        first = second = -1
                        break
            if first == second == -1:
                continue
            result += (1 + num + first + second)
        return result
                
                