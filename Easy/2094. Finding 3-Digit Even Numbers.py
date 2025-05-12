from collections import Counter
from typing import List


class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        counts = Counter(digits)
        result = []
        for num in range(100, 1000, 2):
            if all(counts[k] >= v for k, v in Counter(int(c) for c in str(num)).items()):
                result.append(num)
        return result                    