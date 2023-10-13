class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int[] dp = new int[n + 1];
        int first = 0, second = 0, third = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            third = Math.min(first + cost[i - 2], second + cost[i - 1]);
            first = second;
            second = third;
        }
        return third;
    }
}