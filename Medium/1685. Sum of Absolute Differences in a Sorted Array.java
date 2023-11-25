class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int diff = 0;
        for (int i = 1; i < len; i++) {
            diff += (nums[i] - nums[0]);
        }
        int[] diffs = new int[len];
        diffs[0] = diff;
        for (int i = 1; i < len; i++) {
            diffs[i] = diffs[i - 1] + (i * 2 - len) * (nums[i] - nums[i - 1]);
        }
        return diffs;
    }
}

/**
 * nums = [1, 4, 6, 8, 10]
 * diffs = [3, 2, 2, 2]
 * 1st = (3 * 4) + (2 * 3) + (2 * 2) + (2 * 1)
 * 2nd = (3 * 1) | (2 * 3) + (2 * 2) + (2 * 1)
 * 3rd = (3 * 1) + (2 * 2) | (2 * 2) + (2 * 1)
 * 4th = (3 * 1) + (2 * 2) + (2 * 3) | (2 * 1)
 * 5th = (3 * 1) + (2 * 2) + (2 * 3) + (2 * 4)
 * (i)th = (i - 1)th - (len - i) * (nums[i] - nums[i - 1]) + i * (nums[i] -
 * nums[i - 1])
 */