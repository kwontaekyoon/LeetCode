from typing import List


class Solution:
    def maxCount(self, banned: List[int], n: int, max_sum: int) -> int:
        banned = set(banned)
        cnt = 0
        for num in range(1, n + 1):
            if max_sum - num < 0:
                break
            if num not in banned:
                cnt += 1
                max_sum -= num
        return cnt