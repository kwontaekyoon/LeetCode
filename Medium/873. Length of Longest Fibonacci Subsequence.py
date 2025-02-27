from collections import defaultdict
from typing import List


class HashTable:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        lookup = {num: defaultdict(lambda: 2) for num in arr}
        res = 0
        for i in range(2, len(arr)):
            curr = arr[i]
            for j in range(i - 1, 0, -1):
                prev = arr[j]
                prev_prev = curr - prev
                if prev_prev >= prev:
                    break
                if prev_prev not in lookup:
                    continue
                lookup[curr][prev] = lookup[prev][prev_prev] + 1
                res = max(lookup[curr][prev], res)
        return res

class DP:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        n = len(arr)
        dp = [[0] * n for _ in range(n)]
        res = 0
        for i in range(2, n):
            l, r = 0, i - 1
            while l < r:
                s = arr[l] + arr[r]
                if s > arr[i]:
                    r -= 1
                elif s < arr[i]:
                    l += 1
                else:
                    dp[r][i] = dp[l][r] + 1
                    res = max(dp[r][i], res)
                    r -= 1
                    l += 1
        return res + 2 if res else 0
