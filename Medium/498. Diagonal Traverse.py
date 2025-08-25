from typing import List


class Solution:
    def findDiagonalOrder(self, M: List[List[int]]) -> List[int]:
        R, C = len(M), len(M[0])
        result = []
        r, c = 0, 0
        rev = False
        while True:
            curr_r, curr_c = r, c
            curr = []
            while curr_r >= 0 and curr_c < C:
                curr.append(M[curr_r][curr_c])
                curr_r -= 1
                curr_c += 1
            curr = curr[::-1] if rev else curr
            result.extend(curr)
            if r == R - 1 and c == C - 1:
                break
            if r == R - 1:
                c += 1
            else:
                r += 1
            rev = False if rev else True
        return result