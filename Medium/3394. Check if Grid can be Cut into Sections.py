from typing import List


class Solution:
    def checkValidCuts(self, n: int, rectangles: List[List[int]]) -> bool:
        def check(intervals: List[List[int]]) -> bool:
            intervals.sort()
            sections = 0
            max_end = -1
            for start, end in intervals:
                if max_end <= start:
                    sections += 1
                max_end = max(end, max_end)
            return sections > 2
        x_intervals = [[rect[0], rect[2]] for rect in rectangles]
        y_intervals = [[rect[1], rect[3]] for rect in rectangles]
        return check(x_intervals) or check(y_intervals)