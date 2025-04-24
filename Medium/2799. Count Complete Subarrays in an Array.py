from collections import defaultdict
from typing import List


class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        target = len(set(nums))
        result = 0
        mpp = defaultdict(int)
        l = r = 0
        while r < len(nums):
            while r < len(nums) and len(mpp) < target:
                mpp[nums[r]] += 1
                r += 1
            while len(mpp) == target:
                result += len(nums) - r + 1
                mpp[nums[l]] -= 1
                if mpp[nums[l]] == 0:
                    del mpp[nums[l]]
                l += 1
        return result


class Solution1:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        target = len(set(nums))
        result = 0
        curr_map = defaultdict(int)
        l = 0
        for r in range(len(nums)):
            curr_map[nums[r]] += 1
            while len(curr_map) == target:
                result += len(nums) - r
                curr_map[nums[l]] -= 1
                if curr_map[nums[l]] == 0:
                    del curr_map[nums[l]]
                l += 1
        return result