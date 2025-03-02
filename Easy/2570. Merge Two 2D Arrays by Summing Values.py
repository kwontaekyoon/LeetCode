from typing import List


class TwoPointers:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        n, m, i, j = len(nums1), len(nums2), 0, 0
        res = []
        while i < n and j < m:
            if nums1[i][0] == nums2[j][0]:
                res.append([nums1[i][0], nums1[i][1] + nums2[j][1]])
                i += 1
                j += 1
            elif nums1[i][0] < nums2[j][0]:
                res.append(nums1[i])
                i += 1
            else:
                res.append(nums2[j])
                j += 1
        while i < n:
            res.append(nums1[i])
            i += 1
        while j < m:
            res.append(nums2[j])
            j += 1
        return res

class TwoPointers1:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        m = len(nums2)
        j = 0
        res = []
        for num1 in nums1:
            while j < m and nums2[j][0] < num1[0]:
                res.append(nums2[j])
                j += 1
            if j < m and nums2[j][0] == num1[0]:
                res.append([num1[0], num1[1] + nums2[j][1]])
                j += 1
            else:
                res.append(num1)
        while j < m:
            res.append(nums2[j])
            j += 1
        return res