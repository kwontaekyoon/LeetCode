class Solution:
    def kMirror(self, k: int, n: int) -> int:
        def makePalindrome(num: int, odd: bool) -> int:
            x = num
            if odd:
                x //= 10
            while x > 0:
                num = num * 10 + x % 10
                x //= 10
            return num

        def isValid(num: int, base: int) -> bool:
            digits = []
            while num > 0:
                digits.append(num % base)
                num //= base
            return digits == digits[::-1]

        result = 0
        length = 1
        while n > 0:
            for i in range(length, length * 10):
                if n <= 0:
                    break
                p = makePalindrome(i, True)
                if isValid(p, k):
                    result += p
                    n -= 1
            for i in range(length, length * 10):
                if n <= 0:
                    break
                p = makePalindrome(i, False)
                if isValid(p, k):
                    result += p
                    n -= 1
            length *= 10
        return result