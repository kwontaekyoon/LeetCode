from bisect import bisect_right

class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        res, full, dry = [-1] * len(rains), {}, []
        for i, lake in enumerate(rains):
            if lake == 0:
                dry.append(i)
                res[i] = 1
            elif lake in full:
                j = bisect.bisect_right(dry, full[lake])
                if j == len(dry):
                    return []
                res[dry[j]] = lake
                dry.pop(j)
                full[lake] = i
            else:
                full[lake] = i
        return res

class Solution1:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        full = set()
        drying = deque()
        result = []
        for i, v in enumerate(rains):
            if v == 0:
                result.append(1)
                drying.append(i)
            elif v in full:
                if not drying:
                    return []
                result[drying.popleft()] = v
                result.append(-1)
            else:
                result.append(-1)
                full.add(v)
        return result
            