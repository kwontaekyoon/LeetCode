from typing import List


class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=lambda x: x[1])
        prev_lo, prev_hi = intervals[0][1] - 1, intervals[0][1]
        size = 2
        for curr_lo, curr_hi in intervals[1:]:
            # no overlap
            if prev_hi < curr_lo: 
                size += 2
                prev_lo, prev_hi = curr_hi - 1, curr_hi
            # overlap
            elif prev_lo < curr_lo:
                size += 1
                if prev_hi == curr_hi:
                    prev_lo = curr_hi - 1
                    prev_hi = curr_hi
                else:
                    prev_lo = prev_hi
                    prev_hi = curr_hi
        return size

class Solution1:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        result = []
        for lo, hi in sorted(intervals, key=lambda x: (x[1], -x[0])):
            # print(lo, hi)
            if not result or result[-1] < lo:
                result.extend([hi - 1, hi])
                # print(result)
                continue
            if not lo <= result[-2] <= hi:
                result.append(hi)
            # print(result)
        return len(result)
                