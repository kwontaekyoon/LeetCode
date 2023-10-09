class Solution {
    public int[] twoSum(int[] nums, int goal) {
        int l = 0, r = nums.length - 1;
        while (nums[l] + nums[r] != goal) {
            if (nums[l] + nums[r] > goal) {
                r--;
            } else {
                l++;
            }
        }
        return new int[] { l + 1, r + 1 };
    }
}

/**
 * binary search approach
 * class Solution {
 * private int bs(int left, int right, int[] numbers, int target) {
 * int mid = right;
 * while (left <= right) {
 * mid = (left + right) / 2;
 * if (numbers[mid] == target) {
 * return mid;
 * }
 * if (numbers[mid] > target) {
 * right = mid - 1;
 * } else {
 * left = mid + 1;
 * }
 * }
 * return mid;
 * }
 * public int[] twoSum(int[] numbers, int target) {
 * for (int left = 0, right = numbers.length - 1; left < right; left++) {
 * int bsRes = bs(left + 1, right, numbers, target - numbers[left]);
 * if (numbers[bsRes] + numbers[left] == target) {
 * return new int[] { left + 1, bsRes + 1 };
 * } else {
 * right = bsRes;
 * }
 * }
 * return new int[] { -1, -1 };
 * }
 * }
 */