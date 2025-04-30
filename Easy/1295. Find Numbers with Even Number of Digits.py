import math
from typing import List


class Math:
    def findNumbers(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            if not (int(math.log10(num)) + 1) % 2:
                result += 1
        return result

class String:
    def findNumbers(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            if not len(str(num)) % 2:
                result += 1
        return result