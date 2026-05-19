class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        p1 = p2 = 0
        n, m = len(nums1), len(nums2)
        while p1 < n and p2 < m:
            if nums1[p1] == nums2[p2]:
                return nums1[p1]
            if nums1[p1] > nums2[p2]:
                p2 += 1
            else:
                p1 += 1
        return -1
