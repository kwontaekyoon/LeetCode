class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        summ = sum(nums)
        maxx = sum(i * v for i, v in enumerate(nums))
        curr = maxx 
        n = len(nums)
        for i in range(n - 1):
            curr += nums[i] * n - summ
            maxx = max(curr, maxx)
        return maxx
