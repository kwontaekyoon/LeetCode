from collections import deque
from typing import List


class Optimized:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n, k = len(nums), len(queries)
        diff = [0 for _ in range(n + 1)]
        queue = deque(queries)
        curr_diff = 0
        for i, num in enumerate(nums):
            curr_diff += diff[i]
            while queue and curr_diff < num:
                l, r, val = queue.popleft()
                diff[l] += val
                diff[r + 1] -= val
                if l <= i <= r:
                    curr_diff += val
            if curr_diff < num:
                return -1
        return k - len(queue)

# O(log(k) * n)
class BinarySearch:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        def canMakeZeroArray(k: int) -> bool:
            diff = [0] * (len(nums) + 1)
            for i in range(k):
                l, r, v = queries[i]
                diff[l] += v
                diff[r + 1] -= v
            curr_diff = 0
            for i, n in enumerate(nums):
                curr_diff += diff[i]
                if curr_diff < n:
                    return False
            return True

        if sum(nums) == 0:
            return 0
        l, r = 1, len(queries)
        if not canMakeZeroArray(r):
            return -1
        while l < r:
            m = (l + r) // 2
            if canMakeZeroArray(m):
                r = m
            else:
                l = m + 1
        return l

# TLE -> O(n * k)
class BruteForce:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        total = sum(nums)
        k = 0
        for l, r, val in queries:
            if total == 0:
                return k
            for i in range(l, r + 1):
                total -= min(val, nums[i])
                nums[i] = max(nums[i] - val, 0)
            k += 1
        return -1 if total else k