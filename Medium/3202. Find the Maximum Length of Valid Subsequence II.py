from typing import List


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        result = 2
        for j in range(k):
            dp = [0] * k
            for num in nums:
                mod = num % k
                pos = (j - mod) % k
                dp[mod] = dp[pos] + 1
            result = max(result, max(dp))
        return result