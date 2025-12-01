from typing import List


class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        total = sum(batteries)
        batteries.sort()
        while batteries[-1] > total // n:
            n -= 1
            total -= batteries.pop()
        return total // n