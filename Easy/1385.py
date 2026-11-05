class Solution:
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        within = 0
        for v1 in arr1:
            found = False
            for v2 in arr2:
                if abs(v1 - v2) <= d:
                    found = True
                    break
            if not found:
                within += 1
        return within