class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        stack = [intervals[0]]
        for start, end in intervals[1:]:
            # check if prev intervals overlap with curr one
            while stack and stack[-1][0] == start:
                stack.pop()
            # check if curr interval overlaps with prev one
            if not stack or stack[-1][-1] < end:
                stack.append([start, end])
        return len(stack)
