class Solution {
    public int maxSubArray(int[] nums) {

        /**
         * O(n2) BF
         * int maxSum = Integer.MIN_VALUE, n = nums.length;
         * for (int start = 0; start < n; start++) {
         * int curSum = nums[start];
         * maxSum = Math.max(curSum, maxSum);
         * for (int end = start + 1; end < n; end++) {
         * curSum += nums[end];
         * maxSum = Math.max(curSum, maxSum);
         * }
         * }
         * return maxSum;
         */

        /**
         * O(n) DP
         * int n = nums.length;
         * int[][] dp = new int[2][n];
         * dp[0][0] = nums[0];
         * dp[1][0] = nums[0];
         * for (int i = 1; i < n; i++) {
         * dp[0][i] = Math.max(dp[0][i - 1] + nums[i], nums[i]);
         * dp[1][i] = Math.max(dp[0][i], dp[1][i - 1]);
         * }
         * return dp[1][n - 1];
         */

        int n = nums.length;
        int maxSum = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(curMax, maxSum);
        }
        return maxSum;
    }
}