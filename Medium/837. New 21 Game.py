class Solution1:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        if k == 0 or n >= k + maxPts: return 1
        dp = [1.0] + [0.0] * n
        curr = 1
        for i in range(1, n + 1):
            dp[i] = curr / maxPts
            if i < k:
                curr += dp[i]
            if i >= maxPts:
                curr -= dp[i - maxPts]
        return sum(dp[k:])

class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        if k == 0 or n >= k - 1 + maxPts:
            return 1.0
        dp = [0.0] * maxPts
        dp[0] = 1.0
        window_sum = 1.0
        result = 0.0
        for i in range(1, n + 1):
            prob = window_sum / maxPts
            if i < k:
                window_sum += prob
            else:
                result += prob
            if i >= maxPts:
                window_sum -= dp[i % maxPts]
            dp[i % maxPts] = prob
        return result