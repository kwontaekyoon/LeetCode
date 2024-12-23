import heapq
from typing import List


class BinarySearch:
    def leftmostBuildingQueries(self, heights: List[int], queries: List[List[int]]) -> List[int]:
        n = len(heights)
        st = [[0] * 20 for _ in range(n)]
        log = [-1] * (n + 1)
        log[0] = -1
        for i in range(1, n + 1):
            log[i] = log[i >> 1] + 1
        for i in range(n):
            st[i][0] = heights[i]
        for i in range(1, 20):
            for j in range(n):
                if j + (1 << i) <= n:
                    st[j][i] = max(st[j][i - 1], st[j + (1 << (i - 1))][i - 1])

        def ask(l: int, r: int) -> int:
            k = log[r - l + 1]
            return max(st[l][k], st[r - (1 << k) + 1][k])

        res = []
        for l, r in queries:
            if l > r:
                l, r = r, l
            if l == r:
                res.append(l)
                continue
            if heights[r] > heights[l]:
                res.append(r)
                continue
            max_height = max(heights[r], heights[l])
            left, right = r + 1, n
            while left < right:
                mid = (left + right) // 2
                if ask(r + 1, mid) > max_height:
                    right = mid
                else:
                    left = mid + 1
            res.append(left if left != n else -1)
        return res

class Heap:
    def leftmostBuildingQueries(self, heights: list[int], queries: list[list[int]]) -> list[int]:
        result = [-1]*len(queries)
        qs = [[] for _ in range(len(heights))]
        for i, (a, b) in enumerate(queries):
            if a > b:
                a, b = b, a
            if a == b or heights[a] < heights[b]:
                result[i] = b
            else:
                qs[b].append((heights[a], i))
        min_heap = []
        for i, h in enumerate(heights):
            for q in qs[i]:
                heapq.heappush(min_heap, q)
            while min_heap and min_heap[0][0] < h:
                _, j = heapq.heappop(min_heap)
                result[j] = i
        return result