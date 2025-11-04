class Solution:
    def minCost(self, colours: str, times: List[int]) -> int:
        prev_colour = prev_time = None
        result = 0
        for colour, time in zip(colours, times):
            if colour == prev_colour:
                result += min(time, prev_time)
                prev_time = max(prev_time, time)
            else:
                prev_colour = colour
                prev_time = time
        return result