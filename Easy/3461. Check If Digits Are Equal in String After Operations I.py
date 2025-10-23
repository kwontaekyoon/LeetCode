class Solution:
    def hasSameDigits(self, s: str) -> bool:
        nums = list(map(int, list(s)))
        while len(nums) > 2:
            nums = [(nums[i - 1] + nums[i]) % 10 for i in range(1, len(nums))]
        return nums[0] == nums[-1]