from typing import List


class Solution1:
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
        return res + nums1[i:] + nums2[j:]

class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        m = len(nums2)
        j = 0
        res = []
        for i, num1 in enumerate(nums1):
            while j < m and nums2[j][0] < num1[0]:
                res.append(nums2[j])
                j += 1
            if j == m:
                return res + nums1[i:]
            if nums2[j][0] == num1[0]:
                res.append([num1[0], num1[1] + nums2[j][1]])
                j += 1
            else:
                res.append(num1)
        return res + nums2[j:]