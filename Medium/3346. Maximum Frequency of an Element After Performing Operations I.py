from typing import List


class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        max_val = max(nums) + k + 2
        count = [0] * max_val
        for num in nums:
            count[num] += 1
        for i in range(1, max_val):
            count[i] += count[i - 1]
        result = 0
        for i in range(max_val):
            left = max(0, i - k)
            right = min(max_val - 1, i + k)
            total = count[right] - (count[left - 1] if left else 0)
            freq = count[i] - (count[i - 1] if i else 0)
            result = max(result, freq + min(numOperations, total - freq))
        return result