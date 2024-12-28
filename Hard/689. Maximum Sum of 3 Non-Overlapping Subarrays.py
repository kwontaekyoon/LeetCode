from typing import List


class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums) - k + 1
        prefix = 0
        for i in range(k):
            prefix += nums[i]
        prefix_sum = [prefix]
        for i in range(k, len(nums)):
            prefix += nums[i] - nums[i - k]
            prefix_sum.append(prefix)
        max_left = [0] * n
        for i in range(1, n):
            max_left[i] = i if prefix_sum[i] > prefix_sum[max_left[i - 1]] else max_left[i - 1]
        max_right = [0] * n
        max_right[n - 1] = n - 1
        for i in range(n - 2, -1, -1):
            max_right[i] = i if prefix_sum[i] >= prefix_sum[max_right[i + 1]] else max_right[i + 1]
        max_sum = -1
        res = []
        for i in range(k, n - k):
            cur_sum = prefix_sum[max_left[i - k]] + prefix_sum[i] + prefix_sum[max_right[i + k]]
            if cur_sum > max_sum:
                res = [max_left[i - k], i, max_right[i + k]]
                max_sum = cur_sum
        return res
        

# TLE
class Backtracking:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums) - k
        prefix = 0
        for i in range(k):
            prefix += nums[i]
        prefix_sum = [prefix]
        for i in range(k, len(nums)):
            prefix += nums[i] - nums[i - k]
            prefix_sum.append(prefix)
        max_sum = -1
        res = [-1, -1, -1]
        def backtrack(i: int, cur_sum: int, idxs: List[int]) -> None:
            if len(idxs) == 3:
                nonlocal max_sum
                if max_sum < cur_sum:
                    nonlocal res
                    res = list(idxs)
                    max_sum = cur_sum
                return
            while i <= n:
                cur_sum += prefix_sum[i]
                idxs.append(i)
                backtrack(i + k, cur_sum, idxs)
                cur_sum -= prefix_sum[i]
                idxs.pop()
                i += 1
        backtrack(0, 0, [])
        return res
        