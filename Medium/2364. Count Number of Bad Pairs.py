from collections import Counter, defaultdict
from typing import List


class Optimized:
    def countBadPairs(self, nums: List[int]) -> int:
        n = len(nums)
        count = Counter(num - index for index, num in enumerate(nums))
        total_pairs = n * (n - 1) // 2 
        for val in count.values():
            if val < 2:
                continue
            total_pairs -= val * (val - 1) // 2
        return total_pairs

class HashTable:
    def countBadPairs(self, nums: List[int]) -> int:
        map = defaultdict(int)
        res = 0
        for index, num in enumerate(nums):
            num_idx = num - index
            res += (index - map[num_idx])
            map[num_idx] += 1
        return res

