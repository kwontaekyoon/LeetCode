from typing import List


class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        if k == 1 or len(weights) == k:
            return 0
        sorted_pair_sums = sorted([weights[i] + weights[i + 1] for i in range(len(weights) - 1)])
        return sum(sorted_pair_sums[-k + 1:]) - sum(sorted_pair_sums[:k - 1])