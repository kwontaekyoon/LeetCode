from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        for i, n in enumerate(nums):
            res = -1
            d = 1
            while (n & d) != 0:
                res = n - d
                d <<= 1
            nums[i] = res
        return nums

class Solution1:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:
            if num & 1:
                ans.append(num & ~((num + 1) & ~num) >> 1)
            else:
                ans.append(-1)
        return ans