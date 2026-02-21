class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        primes = {2, 3, 5, 7, 11, 13, 17, 19}
        res = 0
        for i in range(left, right + 1):
            if (i.bit_count() in primes):
                res += 1
        return res

class Solution1:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        count = 0
        
        for i in range(left, right + 1):
            setBits = bin(i).count('1')  # Convert to binary and count '1's
            if self.isPrime(setBits):
                count += 1
        
        return count
    
    def isPrime(self, n: int) -> bool:
        if n <= 1:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True