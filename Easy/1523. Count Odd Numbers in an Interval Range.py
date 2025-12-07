class Solution:
    def countOdds(self, low: int, high: int) -> int:
        interval_size = high - low + 1
        if interval_size % 2:
            return interval_size // 2 + low % 2
        return interval_size // 2