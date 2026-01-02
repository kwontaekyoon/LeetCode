from typing import List


class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        hash_set = set()
        for num in nums:
            if num in hash_set:
                return num
            hash_set.add(num)
        return -1