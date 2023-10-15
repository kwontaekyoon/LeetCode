class Solution {
    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        int C = Math.min(arrLen, steps / 2 + 1), R = steps + 1;
        int[][] dp = new int[R][C];
        dp[0][0] = 1;
        for (int step = 1; step < R; step++) {
            for (int idx = 0; idx < C; idx++) {
                dp[step][idx] = dp[step - 1][idx];
                if (idx > 0) {
                    dp[step][idx] = (dp[step][idx] + dp[step - 1][idx - 1]) % MOD;
                }
                if (idx < C - 1) {
                    dp[step][idx] = (dp[step][idx] + dp[step - 1][idx + 1]) % MOD;
                }
            }
        }
        return dp[R - 1][0];
    }
}