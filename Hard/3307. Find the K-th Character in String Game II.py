from typing import List


class Solution:
    def kthCharacter(self, k: int, ops: List[int]) -> str:
        n, i = 1, 0
        while n < k:
            n <<= 1
            i += 1
        d = 0
        while n > 1:
            if k > n // 2:
                k -= n // 2
                d += ops[i - 1]
            n >>= 1
            i -= 1
        return chr(d % 26 + ord("a"))

# TLE
class BF:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        result = 'a'
        for ops in operations:
            if len(result) >= k:
                return result[k - 1]
            if ops == 0:
                result *= 2
            else:
                new = ''
                for c in result:
                    if c == 'z':
                        new += 'a'
                    else:
                        new += chr(ord(c) + 1)
                result += new
        return result[k - 1]