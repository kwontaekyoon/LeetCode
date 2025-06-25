import bisect
from typing import List


class Solution:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        def countPairs(x: int) -> int:
            count = 0
            for a in nums1:
                if a > 0:
                    count += bisect.bisect_right(nums2, x // a)
                elif a < 0:
                    target = x // a
                    if x % a != 0:
                        target += 1
                    count += len(nums2) - bisect.bisect_left(nums2, target)
                else:
                    if x >= 0:
                        count += len(nums2)
            return count
        lo, hi = -10 ** 10, 10 ** 10
        while lo < hi:
            mi = (lo + hi) // 2
            if countPairs(mi) < k:
                lo = mi + 1
            else:
                hi = mi
        return lo
    
class Optimized:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        positive1 = []
        negative1 = []
        for num1 in nums1:
            if num1 >= 0:
                positive1.append(num1)
            else:
                negative1.append(-num1)
        negative1.reverse()
        
        positive2 = []
        negative2 = []
        for num2 in nums2:
            if num2 >= 0:
                positive2.append(num2)
            else:
                negative2.append(-num2)
        negative2.reverse()

        negative_count = len(positive1) * len(negative2) + len(negative1) * len(positive2)
        if k > negative_count:
            k -= negative_count
            sign = 1
        else:
            k = negative_count - k + 1
            positive2, negative2 = negative2, positive2
            sign = -1

        def count_pairs(arr1: List[int], arr2: List[int], cap: int):
            res = 0
            n2 = len(arr2)
            rp = n2 - 1
            for num1 in arr1:
                while rp >= 0 and num1 * arr2[rp] > cap:
                    rp -= 1
                res += rp + 1
            return res
        
        lp = 0
        up = pow(10, 10)
        while lp < up:
            mp = (lp + up) >> 1
            if count_pairs(positive1, positive2, mp) + count_pairs(negative1, negative2, mp) >= k:
                up = mp
            else:
                lp = mp + 1
        return lp * sign