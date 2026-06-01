class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        n = len(cost)
        i = n - 1
        cost.sort()
        min_cost = 0
        while i > 1:
            min_cost += cost[i] + cost[i - 1]
            i -= 3
        return min_cost + sum(cost[:i + 1])
