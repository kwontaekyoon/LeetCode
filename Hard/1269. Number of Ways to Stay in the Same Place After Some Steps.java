class Solution {
    private static final int MOD = 1000000007;

    public int numWays(int steps, int arrLen) {
        int C = Math.min(arrLen, steps / 2 + 1), R = steps + 1;
        int[] dp = new int[C];
        dp[0] = 1;
        for (int step = 1; step < R; step++) {
            int[] tmp = new int[C];
            for (int idx = 0; idx < C; idx++) {
                tmp[idx] = dp[idx];
                if (idx > 0) {
                    tmp[idx] = (tmp[idx] + dp[idx - 1]) % MOD;
                }
                if (idx < C - 1) {
                    tmp[idx] = (tmp[idx] + dp[idx + 1]) % MOD;
                }
            }
            dp = tmp;
        }
        return dp[0];
    }
}