from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        num_set = set()
        for num in nums:
            if num < k:
                return -1
            if num > k:
                num_set.add(num)
        return len(num_set)