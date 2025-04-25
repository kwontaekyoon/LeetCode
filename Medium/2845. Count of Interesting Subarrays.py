from typing import List


class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        mpp = {0: 1}
        result = count = 0
        for num in nums:
            if num % modulo == k:
                count = (count + 1) % modulo
            need = (count - k + modulo) % modulo
            result += mpp.get(need, 0)
            mpp[count] = mpp.get(count, 0) + 1  
        return result
