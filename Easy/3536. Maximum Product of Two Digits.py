class Solution:
    def maxProduct(self, n: int) -> int:
        biggest = second = -1
        while n:
            num = n % 10
            if num > biggest:
                second = biggest
                biggest = num
            elif num > second:
                second = num
            n //= 10
        return biggest * second
        