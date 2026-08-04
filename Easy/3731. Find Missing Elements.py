class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        minval = float('inf')
        maxval = -float('inf')
        for num in nums:
            minval = min(num, minval)
            maxval = max(num, maxval)
        numset = set(nums)
        res = []
        for num in range(minval + 1, maxval):
            if num not in numset:
                res.append(num)
        return res