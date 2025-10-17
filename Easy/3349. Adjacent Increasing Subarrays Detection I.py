class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        streaks = [1] * len(nums)
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                streaks[i] += streaks[i - 1]
        for i in range(k * 2 - 1, len(nums)):
            if streaks[i] >= k and streaks[i - k] >= k:
                return True
        return False