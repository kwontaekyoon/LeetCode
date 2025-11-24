from typing import List


class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        prefix = 0
        result = []
        for num in nums:
            prefix = (prefix * 2 + num) % 5
            result.append(prefix % 5 == 0)
        return result