class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int r = Math.min(n - i - 1, nums[i]); r > 0 && dp[i + r] == n; r--) {
                dp[i + r] = Math.min(dp[i] + 1, dp[i + r]);
            }
        }
        return dp[n - 1];
    }
}
