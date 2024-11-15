from typing import List


class TwoPointers:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n = len(arr)
        left, right= 0, n - 1
        while left < n - 1 and arr[left] <= arr[left + 1]:
            left += 1
        if left == n - 1:
            return 0
        while right > 0 and arr[right - 1] <= arr[right]:
            right -= 1
        res = min(n - left - 1, right)
        i, j = 0, right
        while i <= left and j < n:
            if arr[i] <= arr[j]:
                res = min(res, j - i - 1)
                i += 1
            else:
                j += 1
        return res

class BinarySearch:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n = len(arr)
        left, right = 0, n - 1
        while left < n - 1 and arr[left] <= arr[left + 1]:
            left += 1
        if left == n - 1:
            return 0
        while right > 0 and arr[right - 1] <= arr[right]:
            right -= 1
        lo, hi = 0, len(arr) - 1
        ans = None
        while lo <= hi:
            mi = (lo + hi) // 2
            if self.possible(arr, mi, left, right):
                ans = mi
                hi = mi - 1
            else:
                lo = mi + 1
        return ans
    
    def possible(self, arr: List[int], m: int, left: int, right: int) -> bool:
        for i in range(len(arr) - m + 1):
            if i <= left + 1 and i + m >= right and (i == 0 or i == len(arr) - m or arr[i - 1] <= arr[i + m]):
                return True
        return False