import bisect
from typing import List


class Solution:
    def maxTaskAssign(self, tasks: List[int], workers: List[int], pills: int, strength: int) -> int:
        tasks.sort()
        workers.sort()
        low, high = 0, min(len(tasks), len(workers))
        while low < high:
            mid = (low + high + 1) // 2
            used_pills = 0
            available = workers[-mid:]
            can_assign = True
            for task in reversed(tasks[:mid]):
                if available[-1] >= task:
                    available.pop()
                else:
                    idx = bisect.bisect_left(available, task - strength)
                    if idx == len(available) or used_pills == pills:
                        can_assign = False
                        break
                    used_pills += 1
                    available.pop(idx)
            if can_assign:
                low = mid
            else:
                high = mid - 1
        return low