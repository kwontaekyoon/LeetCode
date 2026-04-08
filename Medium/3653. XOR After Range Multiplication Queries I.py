MOD = 1000000007
class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        for l, r, k, v in queries:
            for i in range(l, r + 1, k):
                nums[i] = (nums[i] * v) % MOD
        res = nums[0]
        for num in nums[1:]:
            res ^= num
        return res
