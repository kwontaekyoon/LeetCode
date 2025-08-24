from collections import deque
from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        results = []
        result = 0
        for i in range(0, len(nums) - 1):
            if nums[i] == 1:
                result += 1
            else:
                if nums[i + 1] == 1:
                    if 0 in nums[i + 1:]:
                        result += nums.index(0, i + 1) - (i + 1)
                    else:
                        result += len(nums[i + 1:])
                results.append(result)
                result = 0
        for i in results:
            result = max(i, result)
        return result
                   

class Solution1:
    def longestSubarray(self, nums: List[int]) -> int:
        queue = deque([])
        zeros = 0
        result = 0
        for num in nums:
            queue.append(num)
            if not num:
                zeros += 1
                while queue and zeros > 1:
                    if not queue.popleft():
                        zeros -= 1
                        break
            result = max(result, len(queue) - 1)
        return result