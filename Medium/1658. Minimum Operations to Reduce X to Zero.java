class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0, n = nums.length;
        for (int num : nums) {
            target += num;
        }
        if (target == x) {
            return n;
        }
        if (target < x) {
            return -1;
        }

        int maxLength = -1, sum = 0;
        target -= x;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (sum > target) {
                sum -= nums[l++];
            }
            if (sum == target) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
}