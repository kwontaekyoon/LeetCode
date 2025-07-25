from typing import List

class OneLiner:
    def maxSum(self, nums: List[int]) -> int:
        return max(nums) if max(nums) < 0 else sum(num for num in set(nums) if num > 0)
    
class Solution:
    def maxSum(self, nums: List[int]) -> int:
        """
        Returns the maximum sum of unique positive numbers in the list.
        If all numbers are negative, returns the maximum (least negative) number.
        """
        # Filter positive unique numbers and sum them, or return max if all are negative
        unique_positives = [num for num in set(nums) if num > 0]
        if unique_positives:
            return sum(unique_positives)
        return max(nums)

class Solution1:
    def maxSum(self, nums: List[int]) -> int:
        """
        Returns the maximum sum of unique positive numbers in the list.
        If all numbers are negative, returns the maximum (least negative) number.
        """
        max_num = max(nums)
        if max_num < 0:
            return max_num

        seen = set()
        total = 0
        for num in nums:
            # Add only unique positive numbers
            if num > 0 and num not in seen:
                total += num
                seen.add(num)
        return total