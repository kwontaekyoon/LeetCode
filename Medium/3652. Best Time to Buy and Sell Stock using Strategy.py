from typing import List


class Solution:
    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        prefix_original = [0]
        for p, s in zip(prices, strategy):
            prefix_original.append(prefix_original[-1] + p * s)
        max_profit = prefix_original[-1]
        prefix_prices = [0]
        for p in prices:
            prefix_prices.append(prefix_prices[-1] + p)
        n = len(prices)
        for left in range(n - k + 1):
            mid = left + k // 2
            right = left + k
            curr_profit = prefix_original[left] + prefix_prices[right] - prefix_prices[mid] + prefix_original[-1] - prefix_original[right]
            max_profit = max(max_profit, curr_profit)
        return max_profit


class BruteForceTLE:
    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        max_profit = sum(x * y for x, y in zip(prices, strategy))
        n = len(prices)
        for i in range(n - k + 1):
            curr_profit = 0
            for j in range(i):
                curr_profit += prices[j] * strategy[j]
            for j in range(i + k // 2, i + k):
                curr_profit += prices[j]
            for j in range(i + k, n):
                curr_profit += prices[j] * strategy[j]
            max_profit = max(max_profit, curr_profit) 
        return max_profit