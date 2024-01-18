// tabulation
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// memoziation
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return memo(n, dp);
    }
    private int memo(int step, int[] dp) {
        if (step == 0 || step == 1) {
            return 1;
        }
        if (dp[step] != 0) {
            return dp[step];
        }
        return dp[step] = memo(step - 1, dp) + memo(step - 2, dp);
    }
}