from typing import List


class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        low, high = 1, cars * cars * min(ranks)
        res = high
        while low <= high:
            mid = (low + high) // 2
            if cars <= sum(int((mid // rank) ** 0.5) for rank in ranks):
                res = mid
                high = mid - 1
            else:
                low = mid + 1
        return res