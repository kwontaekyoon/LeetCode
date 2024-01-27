class Solution {
    private final static int MOD = (int) 1e9 + 7;
    public int kInversePairs(int N, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int n = 1; n <= N; n++) {
            for (int k = 0; k <= K; k++) {
                if (k == 0) {
                    dp[n][k] = 1;
                    continue;
                }
                int val = dp[n - 1][k];
                if (k - n >= 0) {
                    val = (MOD + val - dp[n - 1][k - n]) % MOD;
                }
                dp[n][k] = (dp[n][k - 1] + val) % MOD;
            }
        }
        return dp[N][K];
    }
}