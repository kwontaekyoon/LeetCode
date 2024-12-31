from typing import List


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        max_day = days[n - 1]
        dp = [0] * (max_day + 1)
        travel_days = set(days)
        for today in range(1, max_day + 1):
            if today not in travel_days:
                dp[today] = dp[today - 1]
                continue
            dp[today] = min(
                dp[today - 1] + costs[0], 
                dp[max(0, today - 7)] + costs[1], 
                dp[max(0, today - 30)] + costs[2]
            )
        return dp[-1]