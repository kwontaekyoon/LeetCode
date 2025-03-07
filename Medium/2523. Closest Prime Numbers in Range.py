class Math:
    def closestPrimes(self, left: int, right: int) -> list[int]:
        primes = [True for _ in range(right + 1)]
        primes[0] = primes[1] = False
        
        for i in range(2, int(right**0.5) + 1):
            if primes[i]:
                for j in range(i*i, right + 1, i):
                    primes[j] = False
        
        primes = [i for i in range(left, right + 1) if primes[i]]
        
        if len(primes) < 2:
            return [-1, -1]
        
        min_gap = float('inf')
        result = [-1, -1]
        
        for i in range(1, len(primes)):
            gap = primes[i] - primes[i-1]
            if gap < min_gap:
                min_gap = gap
                result = [primes[i-1], primes[i]]
        
        return result