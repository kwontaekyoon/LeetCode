from typing import List


class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        i, n = 0, len(nums)
        res = []
        while i < n - 1:
            if nums[i] == 0:
                i += 1
                continue
            if nums[i] == nums[i + 1]:
                res.append(nums[i] * 2)
                i += 1
            else:
                res.append(nums[i])
            i += 1
        if i < n and nums[i]:
            res.append(nums[i])
        while len(res) < n:
            res.append(0)
        return res
