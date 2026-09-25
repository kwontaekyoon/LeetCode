class Solution:
    def minOperations(self, nums: list[int], x: int) -> int:
        n = len(nums)
        target = sum(nums)
        if target == x:
            return n
        if target < x:
            return -1
        l = summ = 0
        maxlength = -1
        target -= x
        for r in range(n):
            summ += nums[r]
            while summ > target:
                summ -= nums[l]
                l += 1
            if summ == target:
                maxlength = max(maxlength, r - l + 1)
        return -1 if maxlength == -1 else n - maxlength