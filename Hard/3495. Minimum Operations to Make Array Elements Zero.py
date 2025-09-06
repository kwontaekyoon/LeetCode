from typing import List

class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        """
        Calculates the minimum number of operations to make array elements zero for each query range.
        """
        # Precompute expSum4 for fast lookup
        exp_sum4 = [1] + [0] * 17

        def exp_sum(x: int) -> int:
            """
            Helper function to compute the sum of exponents for a given x.
            """
            if x == 0:
                return 0
            log4 = (x.bit_length() - 1) >> 1
            r = x - (1 << (log4 << 1))
            return exp_sum4[log4] + r * (log4 + 1)

        # Fill the exp_sum4 array
        for i in range(1, 18):
            exp_sum4[i] = exp_sum4[i - 1] + 3 * i * (1 << (2 * (i - 1))) + 1

        operations = 0
        for l, r in queries:
            # Calculate operations for each query and accumulate
            operations += (exp_sum(r) - exp_sum(l - 1) + 1) >> 1

        return operations