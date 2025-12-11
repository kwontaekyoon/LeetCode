from typing import List


class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        top = [0] * (n + 1)
        bottom = [n + 1] * (n + 1)
        left = [n + 1] * (n + 1)
        right = [0] * (n + 1)
        for x, y in buildings:
            top[x] = max(top[x], y)
            bottom[x] = min(bottom[x], y)
            left[y] = min(left[y], x)
            right[y] = max(right[y], x)
        count = 0
        for x, y in buildings:
            if bottom[x] < y < top[x] and left[y] < x < right[y]:
                count += 1
        return count

class Solution1:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        lo_hi_for_cols = {}
        lo_hi_for_rows = {}
        for r, c in buildings:
            if c not in lo_hi_for_cols:
                lo_hi_for_cols[c] = [r, r]
            else:
                lo_hi_for_cols[c][0] = min(lo_hi_for_cols[c][0], r)
                lo_hi_for_cols[c][1] = max(lo_hi_for_cols[c][1], r)
            if r not in lo_hi_for_rows:
                lo_hi_for_rows[r] = [c, c]
            else:
                lo_hi_for_rows[r][0] = min(lo_hi_for_rows[r][0], c)
                lo_hi_for_rows[r][1] = max(lo_hi_for_rows[r][1], c)
        count = 0
        for r, c in buildings:
            if lo_hi_for_cols[c][0] < r < lo_hi_for_cols[c][1] and lo_hi_for_rows[r][0] < c < lo_hi_for_rows[r][1]:
                count += 1
        return count
            