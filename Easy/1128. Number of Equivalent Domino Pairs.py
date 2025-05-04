from collections import defaultdict
from typing import List


class Solution1:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        count = [0 for _ in range(100)]
        result = 0
        for a, b in dominoes:
            val = a * 10 + b if a >= b else b * 10 + a
            result += count[val]
            count[val] += 1
        return result

class HashTable1:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        pair_to_cnt = defaultdict(int)
        result = 0
        for dominoe in dominoes:
            pair = tuple(sorted(dominoe))
            result += pair_to_cnt[pair]
            pair_to_cnt[pair] += 1
        return result

class HashTable2:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        val_to_cnt = defaultdict(int)
        result = 0
        for a, b in dominoes:
            val = a * 10 + b if a >= b else b * 10 + a
            result += val_to_cnt[val]
            val_to_cnt[val] += 1
        return result
