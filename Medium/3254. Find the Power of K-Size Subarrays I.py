from typing import List


class TwoPointersAndSlidingWindow:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        if k == 1:
            return nums
        res = []
        l = 0
        for r in range(1, len(nums)):
            if nums[r] - nums[r - 1] != 1:
                while l < r and l + k - 1 < len(nums):
                    res.append(-1)
                    l += 1
                l = r
            elif r - l == k - 1:
                res.append(nums[r])
                l += 1
        return res

class PrefixSum:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        streaks = [1]
        for i in range(1, len(nums)):
            streaks.append(streaks[-1] + 1 if nums[i] == nums[i - 1] + 1 else 1)
        res = []
        for i in range(k - 1, len(nums)):
            res.append(nums[i] if streaks[i] >= k else -1)
        return res