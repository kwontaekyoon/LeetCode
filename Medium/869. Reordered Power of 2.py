from typing import Counter


class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        n_to_str = str(n)
        size = len(n_to_str)
        digits_cnt = Counter(n_to_str)
        goal = 1
        while len(str(goal)) < size:
            goal <<= 1
        while len(str(goal)) == size:
            if Counter(str(goal)) == digits_cnt:
                return True
            goal <<= 1
        return False