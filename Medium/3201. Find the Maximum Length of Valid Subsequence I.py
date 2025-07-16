from typing import List


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        evens = odds = even_alts = odd_alts = 0
        for num in nums:
            if num % 2:
                odd_alts = max(odd_alts, even_alts + 1)
                odds += 1
            else:
                even_alts = max(even_alts, odd_alts + 1)
                evens += 1
        return max(evens, odds, even_alts, odd_alts)