class DynamicProgrammingN {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        Arrays.fill(dp[0], 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(nums[i - 1], Math.min(nums[i - 1] * dp[i - 1][0], nums[i - 1] * dp[i - 1][1]));
            dp[i][1] = Math.max(nums[i - 1], Math.max(nums[i - 1] * dp[i - 1][0], nums[i - 1] * dp[i - 1][1]));
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}

class BruteForceN2 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curProduct = 1;
            for (int j = i; j < n; j++) {
                curProduct *= nums[j];
                maxProduct = Math.max(maxProduct, curProduct);
            }
        }
        return maxProduct;
    }
}