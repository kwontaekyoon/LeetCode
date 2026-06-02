class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:
        minL = minW = res = 3000
        for i, (s, d) in enumerate(zip(landStartTime, landDuration)):
            minL = min(s + d, minL)
        for i, (s, d) in enumerate(zip(waterStartTime, waterDuration)):
            minW = min(s + d, minW)
            res = min(max(minL, s) + d, res)
        for i, (s, d) in enumerate(zip(landStartTime, landDuration)):
            res = min(max(minW, s) + d, res)
        return res
