class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int num : nums1) {
        // pq.offer(num);
        // }
        // for (int num : nums2) {
        // pq.offer(num);
        // }
        // double median = 0;
        // int size = pq.size();
        // if (size % 2 == 0) {
        // for (int i = 0; i < size / 2 - 1; i++) {
        // pq.poll();
        // }
        // median = ((double) pq.poll() + (double) pq.poll()) / 2;
        // } else {
        // for (int i = 0; i < size / 2; i++) {
        // pq.poll();
        // }
        // median = (double) pq.poll();
        // }
        // return median;
        int len1 = nums1.length, len2 = nums2.length, target = 0;
        boolean isOdd = false;
        if ((len1 + len2) % 2 == 0) {
            target = (len1 + len2) / 2 - 1;
        } else {
            target = (len1 + len2) / 2;
            isOdd = true;
        }
        int pt1 = 0, pt2 = 0;
        while (target != 0) {
            if (pt1 < len1 && pt2 < len2) {
                if (nums1[pt1] < nums2[pt2]) {
                    pt1++;
                } else {
                    pt2++;
                }
            } else {
                if (pt1 == len1) {
                    pt2++;
                } else if (pt2 == len2) {
                    pt1++;
                }
            }
            target--;
        }

        double median = 0;
        if (pt1 < len1 && pt2 < len2) {
            if (nums1[pt1] < nums2[pt2]) {
                median += (double) nums1[pt1++];
            } else {
                median += (double) nums2[pt2++];
            }
        } else {
            if (pt1 == len1) {
                median += (double) nums2[pt2++];
            } else {
                median += (double) nums1[pt1++];
            }
        }
        if (!isOdd) {
            if (pt1 < len1 && pt2 < len2) {
                if (nums1[pt1] < nums2[pt2]) {
                    median += (double) nums1[pt1];
                } else {
                    median += (double) nums2[pt2];
                }
            } else {
                if (pt1 == len1) {
                    median += (double) nums2[pt2];
                } else {
                    median += (double) nums1[pt1];
                }
            }
            median /= 2;
        }
        return median;
    }
}