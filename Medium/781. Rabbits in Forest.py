from collections import Counter
from typing import List


class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        result = 0
        for k, v in Counter(answers).items():
            q, r = divmod(v, k + 1)
            result += q * (k + 1) + ((k + 1) if r else 0)
        return result