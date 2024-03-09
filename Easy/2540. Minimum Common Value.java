class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int pt1 = 0, pt2 = 0, len1 = nums1.length, len2 = nums2.length;
        if (nums1[len1 - 1] < nums2[0] || nums1[0] > nums2[len2 - 1]) {
            return -1;
        }
        while (pt1 < len1 && pt2 < len2) {
            if (nums1[pt1] == nums2[pt2]) {
                return nums1[pt1];
            } else if (nums1[pt1] < nums2[pt2]) {
                pt1++;
            } else {
                pt2++;
            }
        }
        return -1;
    }
}