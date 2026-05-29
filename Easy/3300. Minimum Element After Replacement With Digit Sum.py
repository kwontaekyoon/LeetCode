class Solution:
    def minElement(self, nums: List[int]) -> int:
        min_sum = 36
        for num in nums:
            cur_sum = 0
            while num:
                cur_sum += num % 10
                num //= 10
            min_sum = min(cur_sum, min_sum)
        return min_sum

class Solution1:
    def minElement(self, nums: List[int]) -> int:
        result = sum(int(c) for c in str(nums[0]))
        for num in nums[1:]:
            result = min(sum(int(c) for c in str(num)), result)
        return result
