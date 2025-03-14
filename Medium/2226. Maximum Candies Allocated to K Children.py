from typing import List


class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        total_candies = sum(candies)
        if total_candies < k:
            return 0
        low, high = 1, total_candies // k
        while low <= high:
            mid = (low + high) // 2
            if sum(candy // mid for candy in candies) >= k:
                low = mid + 1
            else:
                high = mid - 1
        return high