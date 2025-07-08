from typing import List


class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        events.sort(key = lambda x: x[1])
        n = len(events)
        def bs(curr_start: int) -> int:
            low, high = 0, n - 1
            result = -1
            while low <= high:
                mid = (low + high) // 2
                if events[mid][1] < curr_start:
                    result = mid
                    low = mid + 1
                else:
                    high = mid - 1
            return result
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            event = events[i - 1]
            prev = bs(event[0])
            for j in range(1, k + 1):
                dp[i][j] = max(dp[i - 1][j], dp[prev + 1][j - 1] + event[2])
        return dp[n][k]