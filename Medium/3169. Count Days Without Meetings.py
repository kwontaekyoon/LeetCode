from typing import List


class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        prev_start = prev_end = None
        for start, end in sorted(meetings):
            if not prev_end:
                prev_start, prev_end = start, end
            elif prev_end >= start:
                prev_end = max(end, prev_end)
            else:
                days -= prev_end - prev_start + 1
                prev_start, prev_end = start, end
        return days - prev_end + prev_start - 1