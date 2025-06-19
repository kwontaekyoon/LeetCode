from typing import List


class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        result = 1
        min_val = nums[0]
        for num in nums[1:]:
            if num - min_val > k:
                result += 1
                min_val = num
        return result