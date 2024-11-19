from typing import List


class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        uniques = set()
        curr_sum = 0
        max_sum = 0
        left = 0
        for right in range(len(nums)):
            if nums[right] not in uniques:
                curr_sum += nums[right]
                uniques.add(nums[right])
                if right - left + 1 == k:
                    max_sum = max(max_sum, curr_sum)
                    curr_sum -= nums[left]
                    uniques.remove(nums[left])
                    left += 1
            else:
                while nums[left] != nums[right]:
                    curr_sum -= nums[left]
                    uniques.remove(nums[left])
                    left += 1
                left += 1
        return max_sum