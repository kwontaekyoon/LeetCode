class Solution {
    public int[] searchRange(int[] nums, int target) {
        // binary search
        // lower bound and upper bound
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                int lower, upper;
                for (lower = mid; lower >= 0; lower--) {
                    if (nums[lower] != target) {
                        lower++;
                        break;
                    }
                }
                lower = lower == -1 ? 0 : lower;
                for (upper = mid; upper < nums.length; upper++) {
                    if (nums[upper] != target) {
                        upper--;
                        break;
                    }
                }
                upper = upper == nums.length ? nums.length - 1 : upper;
                return new int[] { lower, upper };
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}