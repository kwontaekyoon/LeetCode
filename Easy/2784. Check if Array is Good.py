class Solution:
    def isGood(self, nums: List[int]) -> bool:
        n = max(nums)
        if nums.count(n) != 2:
            return False
        seen = [False] * (n + 1)
        for num in nums:
            if seen[num]:
                if num < n:
                    return False
            else:
                seen[num] = True
        for v in seen[1:]:
            if not v:
                return False
        return True
            
