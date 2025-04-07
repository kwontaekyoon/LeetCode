from typing import List


class BitManipulation:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2:
            return False
        target = total // 2
        bit = 1 << 0
        for num in nums:
            bit |= bit << num
        return (bit & (1 << target)) > 0
        
class DP:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2:
            return False
        target = total // 2
        dp = [False] * (target + 1)
        dp[0] = True
        for num in nums:
            if dp[target - num]:
                return True
            for curr_sum in range(target, num - 1, -1):
                dp[curr_sum] |= dp[curr_sum - num]
        return False
            


class BruteForce:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2:
            return False
        target = total // 2
        sum_set = set([0])
        for num in nums:
            if target - num in sum_set:
                return True
            for prev in list(sum_set):
                sum_set.add(prev + num)
        return False
