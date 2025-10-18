from typing import List


class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        hi = -float('inf')
        result = 0
        for num in sorted(nums):
            if hi < num - k:
                result += 1
                hi = num - k
            elif hi < num + k:
                result += 1
                hi += 1
        return result

class Solution1:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        result = [nums[0] - k]
        for num in nums[1:]:
            candidate = max(result[-1] + 1, num - k)
            if candidate > num + k:
                continue
            result.append(candidate)
        return len(result)