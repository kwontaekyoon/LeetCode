from typing import List


class Solution:
    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)
        gaps = [startTime[0]]
        for i in range(n - 1):
            gaps.append(startTime[i + 1] - endTime[i])
        gaps.append(eventTime - endTime[-1])

        largestRight = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            largestRight[i] = max(largestRight[i + 1], gaps[i + 1])
        
        result = 0
        largestLeft = 0
        for i in range(n):
            currGap = endTime[i] - startTime[i]
            if currGap <= max(largestLeft, largestRight[i + 1]):
                result = max(result, gaps[i] + gaps[i + 1] + currGap)
            result = max(result, gaps[i] + gaps[i + 1])
            largestLeft= max(largestLeft, gaps[i])
            
        return result