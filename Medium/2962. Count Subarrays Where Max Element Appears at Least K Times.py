# sliding window -> O(n)
# count from left
from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        target = max(nums)
        result = count = left = 0
        for num in nums:
            if num == target:
                count += 1
            while count >= k:
                if nums[left] == target:
                    count -= 1
                left += 1
            result += left
        return result

# count from right
class Solution1:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_val = max(nums)
        result = count = 0
        l = 0
        for r, v in enumerate(nums):
            if v == max_val:
                count += 1
            while count >= k:
                result += len(nums) - r
                if nums[l] == max_val:
                    count -= 1
                l += 1
        return result