from typing import List


class OptimizedVersion:
    def getMaximumXor(self, nums: List[int], maximum_bit: int) -> List[int]:
        res = [(1 << maximum_bit) - 1]
        for num in nums:
            res.append(res[-1] ^ num)
        return res[len(res)-1:0:-1]

class BitManipulation:
    def getMaximumXor(self, nums: List[int], maximum_bit: int) -> List[int]:
        res = []
        max = 2 ** maximum_bit - 1
        for i in range(1, len(nums)):
            nums[i] ^= nums[i - 1]
        for xor in nums:
            res.append(xor ^ max)
        return res[::-1]