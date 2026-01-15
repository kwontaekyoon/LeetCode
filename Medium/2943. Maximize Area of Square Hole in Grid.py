from typing import List


class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        if not hBars or not vBars:
            return 1
        def getMaxStreak(bars: List[int]) -> int:
            max_streak = curr = 1
            for i in range(1, len(bars)):
                if bars[i - 1] + 1 == bars[i]:
                    curr += 1
                    max_streak = max(max_streak, curr)
                else:
                    curr = 1
            return max_streak
        return (min(getMaxStreak(sorted(hBars)), getMaxStreak(sorted(vBars))) + 1) ** 2