from typing import List


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        sum1, sum2 = sum(nums1), sum(nums2)
        zero1, zero2 = nums1.count(0), nums2.count(0)
        poss_min1, poss_max1 = sum1 + zero1, float('inf') if zero1 else sum1
        poss_min2, poss_max2 = sum2 + zero2, float('inf') if zero2 else sum2
        if poss_max1 == float('inf') and poss_max2 == float('inf'):
            return max(poss_min1, poss_min2)
        elif poss_max1 != float('inf') and poss_max2 != float('inf'):
            return -1 if sum1 != sum2 else sum1
        elif poss_max1 == float('inf'):
            return -1 if poss_max2 < poss_min1 else poss_max2
        else:
            return -1 if poss_max1 < poss_min2 else poss_max1