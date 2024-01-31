class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (start + end) / 2;
        boolean found = false;
        while (true) {
            if (target == nums[mid]) {
                found = true;
                break;
            } else if (mid >= end || mid <= start) {
                break;
            } else {
                if (target > nums[mid]) {
                    start = mid;
                    mid = (start + end) / 2;
                } else {
                    end = mid;
                    mid = (start + end) / 2;
                }
            }
        }
        if (found) {
            return mid;
        } else {
            return -1;
        }
    }
}