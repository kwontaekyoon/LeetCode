from collections import Counter
from typing import List


class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.n2 = nums2
        self.c1 = Counter(nums1)
        self.c2 = Counter(nums2)

    def add(self, index: int, val: int) -> None:
        self.c2[self.n2[index]] -= 1
        self.n2[index] += val
        self.c2[self.n2[index]] += 1

    def count(self, tot: int) -> int:
        return sum(self.c2[tot - k] * v for k, v in self.c1.items())


# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)