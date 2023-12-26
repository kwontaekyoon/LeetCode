class Solution {
    private final static int MOD = (int) 1e9 + 7;

    // tabulation
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1; // 0 dice = 0
        // from using one dice
        for (int dice = 1; dice < n + 1; dice++) {
            // from when sum is min (numOfDice * 1)
            for (int sum = dice; sum < Math.min(target, dice * k) + 1; sum++) {
                for (int num = 1; num < k + 1; num++) {
                    if (sum - num > -1) {
                        dp[dice][sum] = (dp[dice - 1][sum - num] + dp[dice][sum]) % MOD;
                    }
                }
            }
        }
        return dp[n][target];
    }

    // memoziation
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memo(dp, n, k, target);
    }

    private int memo(int[][] dp, int n, int k, int target) {
        if (target == 0 && n == 0) {
            return 1;
        }
        if (n == 0 || target <= 0) {
            return 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int sum = 0;
        for (int i = 1; i < k + 1; i++) {
            sum = (sum + memo(dp, n - 1, k, target - i)) % MOD;
        }
        return dp[n][target] = sum;
    }
}