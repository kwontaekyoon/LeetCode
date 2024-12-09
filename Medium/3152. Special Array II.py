from bisect import bisect_left
from typing import List


class PrefixSum:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        N = len(nums)
        cnt = [0]
        for i in range(N - 1):
            cnt.append(cnt[-1] + (1 if nums[i] % 2 == nums[i + 1] % 2 else 0))
        return [True if cnt[end] - cnt[start] == 0 else False for start, end in queries]

class BinarySearch:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        N = len(nums)
        not_specials = []
        for i in range(N - 1):
            if nums[i] % 2 == nums[i + 1] % 2:
                not_specials.append(i)
        res = []
        for start, end in queries:
            cnt = bisect_left(not_specials, end) - bisect_left(not_specials, start)
            res.append(False if cnt else True)
        return res