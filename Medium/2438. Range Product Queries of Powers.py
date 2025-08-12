from typing import List

# Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.

# You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.

# Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.
class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        MOD = 10 ** 9 + 7
        max_power = 1
        while max_power < n:
            max_power <<= 1
        powers = []
        while n:
            if n >= max_power:
                powers.append(max_power)
                n -= max_power
            max_power >>= 1
        powers = powers[::-1]
        prefix = [1]
        for power in powers:
            prefix.append(prefix[-1] * power)
        return [prefix[right + 1] // prefix[left] % MOD for left, right in queries]