from collections import defaultdict
import heapq


class Solution:
    def clearStars(self, s: str) -> str:
        n = len(s)
        min_heap = []
        mpp = defaultdict(list)
        keep = [True] * n
        for i, c in enumerate(s):
            if c == '*':
                smallest = heapq.heappop(min_heap)
                idx = mpp[smallest].pop()
                keep[i] = False
                keep[idx] = False
            else:
                heapq.heappush(min_heap, c)
                mpp[c].append(i)
        return ''.join(c for i, c in enumerate(s) if keep[i])