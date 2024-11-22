from collections import Counter
from typing import List


class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        counter = Counter()
        for row in matrix:
            pattern = tuple(row) if row[0] == 0 else tuple(bit ^ 1 for bit in row)
            counter[pattern] += 1
        return max(counter.values())