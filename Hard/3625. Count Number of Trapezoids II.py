from math import gcd
from collections import defaultdict
from typing import List

class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        t = defaultdict(lambda: defaultdict(int))
        v = defaultdict(lambda: defaultdict(int))

        n = len(points)

        for i in range(n):
            x1, y1 = points[i]
            for j in range(i + 1, n):
                x2, y2 = points[j]
                dx = x2 - x1
                dy = y2 - y1

                if dx < 0 or (dx == 0 and dy < 0):
                    dx = -dx
                    dy = -dy

                g = gcd(dx, abs(dy))
                sx = dx // g
                sy = dy // g

                des = sx * y1 - sy * x1

                key1 = (sx << 12) | (sy + 2000)
                key2 = (dx << 12) | (dy + 2000)

                t[key1][des] += 1
                v[key2][des] += 1

        return self.count(t) - self.count(v) // 2

    def count(self, mp):
        ans = 0

        for inner in mp.values():
            total = sum(inner.values())
            remaining = total

            for val in inner.values():
                remaining -= val
                ans += val * remaining

        return ans

class Solution1:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        gradient_intercept = {}
        points.sort()
        for point1 in points:
            for point2 in points:
                if point1 == point2:
                    continue
                (x1, y1), (x2, y2) = sorted([point1, point2])
                if x1 == x2:
                    gradient = float('inf')
                    intercept = x1
                elif y1 == y2:
                    gradient = 0
                    intercept = y1
                else:
                    gradient = (x2 - x1) / (y2 - y1)
                    intercept = y1 - gradient * x1
                if gradient not in gradient_intercept:
                    gradient_intercept[gradient] = defaultdict(set)
                gradient_intercept[gradient][intercept].add((x1, y1))
                gradient_intercept[gradient][intercept].add((x2, y2))
        result = 0
        for intercept_points in gradient_intercept.values():
            # print(intercept_points)
            if len(intercept_points) == 1:
                continue
            combs = []
            for v in intercept_points.values():
                size = len(v)
                if size == 1:
                    continue
                combs.append(size * (size - 1) // 2)
            if len(combs) == 1:
                continue
            # print(combs)
            for i in range(len(combs)):
                for j in range(i + 1, len(combs)):
                    if i == j:
                        continue
                    result += combs[i] * combs[j]
        return result