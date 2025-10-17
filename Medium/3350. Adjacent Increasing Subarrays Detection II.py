class TLE:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        streaks = [1] * n
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                streaks[i] += streaks[i - 1]
        for k in range(n // 2, 1, -1):
            for i in range(k * 2 - 1, n):
                if streaks[i] >= k and streaks[i - k] >= k:
                    return k
        return 1

class Solution:
    def maxIncreasingSubarrays(self, nums: list[int]) -> int:
        n = len(nums)
        curr, prev, result = 1, 0, 0
        for i in range(1, n):
            if nums[i] > nums[i-1]:
                curr += 1
            else:
                prev = curr
                curr = 1
            half = curr >> 1
            m = min(prev, curr)
            candidate = max(half, m)
            if candidate > result:
                result = candidate
        return result