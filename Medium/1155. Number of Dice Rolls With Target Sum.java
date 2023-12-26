class Solution {
    private final static int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        // int[][] dp = new int[n + 1][target + 1];
        // dp[0][0] = 1;
        // for (int r = 1; r < n + 1; r++) {
        // for (int c = r; c < target + 1; c++) {
        // for (int num = 1; num < k + 1; num++) {
        // if (c - num > -1) {
        // dp[r][c] = (dp[r][c] + dp[r - 1][c - num]) % MOD;
        // }
        // }
        // if (dp[r][c] == 0) {
        // break;
        // }
        // }
        // }
        // return dp[n][target];
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