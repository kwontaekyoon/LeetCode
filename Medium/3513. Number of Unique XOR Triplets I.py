class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        n = len(nums)     
        if n <= 2:
            return n
        mask = 0
        for num in nums:
            mask |= num
        return mask + 1


class Solution1:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        hs = set()
        n = len(nums)
        for i in range(n):
            for j in range(i, n):
                for k in range(j, n):
                    hs.add(nums[i] ^ nums[j] ^ nums[k])
        return len(hs)
