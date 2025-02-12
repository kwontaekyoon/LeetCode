from typing import List


class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        digitsum_map = {}
        def numToDigitSum(num: int) -> int:
            digitsum = 0
            while num:
                digitsum += num % 10
                num //= 10
            return digitsum
        for num in nums:
            digitsum = numToDigitSum(num)
            if digitsum not in digitsum_map:
                digitsum_map[digitsum] = [num, -1]
            else:
                if digitsum_map[digitsum][0] < num:
                    digitsum_map[digitsum] = [num, digitsum_map[digitsum][0]]
                elif digitsum_map[digitsum][1] < num:
                    digitsum_map[digitsum] = [digitsum_map[digitsum][0], num]
        return max(sum(nums) if nums[-1] != -1 else -1 for nums in digitsum_map.values())