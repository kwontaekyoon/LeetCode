from typing import List


class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        def canRob() -> bool:
            cnt = 0
            canRob = True
            for num in nums:
                if not canRob:
                    canRob = True
                elif num <= mid:
                    cnt += 1
                    canRob = False
            return cnt >= k
        n = len(nums)
        low, high = min(nums), max(nums)
        res = high
        while low <= high:
            mid = (low + high) // 2
            if canRob():
                res = mid
                high = mid - 1
            else:
                low = mid + 1
        return res