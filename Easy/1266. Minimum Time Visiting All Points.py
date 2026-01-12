from typing import List


class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        result = 0
        prev_x, prev_y = points[0][0], points[0][1]
        for curr_x, curr_y in points[1:]:
            result += max(abs(prev_x - curr_x), abs(prev_y - curr_y))
            prev_x, prev_y = curr_x, curr_y
        return result