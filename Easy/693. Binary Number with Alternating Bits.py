# O(1)
class BitManipulation:
    def hasAlternatingBits(self, n: int) -> bool:
        # 111 ^ 011 = 100
        # 101 ^ 010 = 111
        x = n ^ (n >> 1)
        return (x & (x + 1)) == 0

# O(log(n))
class BruteForce:
    def hasAlternatingBits(self, n: int) -> bool:
        curr = n % 2
        n //= 2
        while n:
            if curr == n % 2:
                return False
            curr = n % 2
            n //= 2
        return True