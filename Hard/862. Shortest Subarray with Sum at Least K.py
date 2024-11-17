# failed
from bisect import bisect_left, bisect_right
from collections import deque
from typing import List


class Solution1:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        res = 100001
        prefix_sums = []
        prefix_sum = 0
        for i in range(len(nums)):
            prefix_sum += nums[i]
            prefix_sums.append(prefix_sum)
            if prefix_sum < k:
                continue
            res = min(res, i - bisect_right(prefix_sums, prefix_sum - k) + 1)
        suffix_sums = deque()
        suffix_sum = 0
        for i in range(len(nums) - 1, -1, -1):
            suffix_sum += nums[i]
            suffix_sums.appendleft(suffix_sum)
            if suffix_sum < k:
                continue
            res = min(res, i - bisect_left(suffix_sums, suffix_sum - k) + 1)
        return res if res < 100001 else -1

class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        res = float("inf")

        cur_sum = 0
        q = deque()  # (prefix_sum, end_idx)

        for r in range(len(nums)):
            cur_sum += nums[r]
            if cur_sum >= k:
                res = min(res, r + 1)

            # Find the minimum valid window ending at r
            while q and cur_sum - q[0][0] >= k:
                prefix, end_idx = q.popleft()
                res = min(res, r - end_idx)

            # Validate the monotonic deque
            while q and q[-1][0] > cur_sum:
                q.pop()
            q.append((cur_sum, r))

        return -1 if res == float("inf") else res