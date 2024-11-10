from typing import List


class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        bit_count = [0] * 32
        current_or = 0
        left = 0
        min_length = float('inf')

        for right in range(len(nums)):
            current_or |= nums[right]
            for bit in range(32):
                if nums[right] & (1 << bit):
                    bit_count[bit] += 1
            
            while left <= right and current_or >= k:
                min_length = min(min_length, right - left + 1)
                updated_or = 0
                for bit in range(32):
                    if nums[left] & (1 << bit):
                        bit_count[bit] -= 1
                    if bit_count[bit] > 0:
                        updated_or |= (1 << bit)
                current_or = updated_or
                left += 1
        
        return -1 if min_length == float('inf') else min_length