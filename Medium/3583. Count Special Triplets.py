from collections import Counter
from typing import List


class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        left, right = Counter(), Counter(nums)
        count = 0
        for num in nums:
            right[num] -= 1
            count += left[num * 2] * right[num * 2]
            left[num] += 1
        return count % 1000000007