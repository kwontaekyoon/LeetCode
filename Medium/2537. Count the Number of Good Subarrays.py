from collections import defaultdict
from typing import List


class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        counter = defaultdict(int)
        result = left = 0
        for num in nums:
            k -= counter[num]
            counter[num] += 1
            while k <= 0:
                counter[nums[left]] -= 1
                k += counter[nums[left]]
                left += 1
            result += left
        return result
