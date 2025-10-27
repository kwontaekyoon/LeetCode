from typing import List


class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        total = prev = 0    
        for row in bank:
            curr = row.count('1')
            if curr:
                total += prev * curr
                prev = curr
        return total