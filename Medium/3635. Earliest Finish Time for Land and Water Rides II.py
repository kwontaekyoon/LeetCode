class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        minL = min(s + d for s, d in zip(landStartTime, landDuration))
        minW = min(s + d for s, d in zip(waterStartTime, waterDuration))
        minWL = min(max(minW, s) + d for s, d in zip(landStartTime, landDuration))
        minLW = min(max(minL, s) + d for s, d in zip(waterStartTime, waterDuration))
        return min(minWL, minLW)

class Solution1:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        minL = minW = res = float('inf')
        for s, d in zip(landStartTime, landDuration):
            minL = min(s + d, minL)
        for s, d in zip(waterStartTime, waterDuration):
            minW = min(s + d, minW)
            res = min(max(minL, s) + d, res)
        for s, d in zip(landStartTime, landDuration):
            res = min(max(minW, s) + d, res)
        return res
