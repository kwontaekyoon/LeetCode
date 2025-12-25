from typing import List


class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness = sorted(happiness, reverse = True)[:k]
        result = 0
        for turn, happy in enumerate(happiness):
            if happy - turn <= 0:
                break
            result += happy - turn
        return result