from heapq import heappush, heappop

class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        maxheap = []
        res = ""
        if a:
            heappush(maxheap, (-a, 'a')) 
        if b:
            heappush(maxheap, (-b, 'b'))
        if c:
            heappush(maxheap, (-c, 'c'))
        while maxheap:
            maxcnt1, maxchar1 = heappop(maxheap)
            if len(res) >= 2 and res[-1] == res[-2] == maxchar1:
                if not maxheap:
                    break
                maxcnt2, maxchar2 = heappop(maxheap)
                res += maxchar2
                maxcnt2 += 1
                if maxcnt2 < 0:
                    heappush(maxheap, (maxcnt2, maxchar2))
                heappush(maxheap, (maxcnt1, maxchar1))
            else:
                res += maxchar1
                maxcnt1 += 1
                if maxcnt1 < 0:
                    heappush(maxheap, (maxcnt1, maxchar1))
        return res
