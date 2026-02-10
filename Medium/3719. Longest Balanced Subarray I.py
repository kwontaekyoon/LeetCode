from typing import List


class BruteForce:
    def longestBalanced(self, nums: List[int]) -> int:
        n = len(nums)
        longest = 0
        for l in range(n):
            even, odd = set(), set()
            if nums[l] % 2:
                odd.add(nums[l])
            else:
                even.add(nums[l])
            for r in range(l + 1, n):
                if nums[r] % 2:
                    odd.add(nums[r])
                else:
                    even.add(nums[r])
                if len(odd) == len(even):
                    longest = max(longest, r - l + 1)
        return longest