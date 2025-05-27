class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        return (n * (n + 1)) // 2 - sum(num for num in range(0, n + 1, m)) * 2