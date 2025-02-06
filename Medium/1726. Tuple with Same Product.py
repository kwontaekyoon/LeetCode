from collections import defaultdict
from typing import List


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        n = len(nums)
        product_to_cnt = defaultdict(int)
        for i in range(n - 1):
            for j in range(i + 1, n):
                product_to_cnt[nums[i] * nums[j]] += 1
        res = 0
        for val in product_to_cnt.values():
            res += 4 * (val - 1) * val
        return res
                