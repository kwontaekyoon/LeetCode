weekly = 7 * 8 // 2
class Solution:
    def totalMoney(self, n: int) -> int:
        weeks = n // 7
        n %= 7
        return weekly * weeks + ((weeks - 1) * weeks) // 2 * 7 + weeks * n + (n * (n + 1)) // 2