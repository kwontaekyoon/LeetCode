from collections import Counter
from typing import List


class SortingSlidingWindow:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        N, res, left = len(nums), 1, 0
        k *= 2
        nums.sort()
        for right in range(N):
            while nums[left] + k < nums[right]:
                left += 1
            res = max(res, right - left + 1)
        return res

class TLE:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        res = 0
        cnt = Counter()
        for num in nums:
            for new in range(num - k, num + k + 1):
                cnt[new] += 1
                res = max(res, cnt[new])
        return res