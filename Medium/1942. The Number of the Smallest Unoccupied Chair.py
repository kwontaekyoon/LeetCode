from ast import List
from heapq import heappush, heappop

class Solution:
    def smallestChair(self, times: List[List[int]], target_friend: int) -> int:
        arrivals = sorted([(times[i][0], i) for i in range(len(times))])
        available_chairs = list(range(len(times)))
        leaving_queue = []
        for time, idx in arrivals:
            while leaving_queue and leaving_queue[0][0] <= time:
                heappush(available_chairs, heappop(leaving_queue)[1])
            if idx == target_friend:
                return heappop(available_chairs)
            heappush(leaving_queue, (times[idx][1], heappop(available_chairs)))
        return -1