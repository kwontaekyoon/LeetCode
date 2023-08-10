class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                if (nums[mid] < nums[right]) { // pivot is in left side
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[left] < nums[mid]) { // pivot is in right side
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[left] == nums[mid])
                        left++;
                    if (nums[mid] == nums[right])
                        right--;
                }
            }
        }
        return false;
    }
}