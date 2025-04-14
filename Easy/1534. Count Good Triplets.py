from typing import List


class Optimized:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        result = 0
        n = len(arr)
        for j in range(1, n - 1):
            valid_prev, valid_next = [], []
            for i in range(j):
                if abs(arr[i] - arr[j]) <= a:
                    valid_prev.append(arr[i])
            if not valid_prev:
                continue
            for k in range(j + 1, n):
                if abs(arr[j] - arr[k]) <= b:
                    valid_next.append(arr[k])
            if not valid_next:
                continue
            for prev in valid_prev:
                for next in valid_next:
                    if abs(prev - next) <= c:
                        result += 1
        return result


class BruteForce:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        result = 0
        for i in range(len(arr) - 2):
            for j in range(i + 1, len(arr) - 1):
                if abs(arr[i] - arr[j]) > a:
                    continue
                for k in range(j + 1, len(arr)):
                    if abs(arr[j] - arr[k]) <= b and abs(arr[i] - arr[k]) <= c:
                        result += 1
        return result