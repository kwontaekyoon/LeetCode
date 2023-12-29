class Solution {
    // 1D
    public int minDifficulty(int[] jobs, int d) {
        int n = jobs.length;
        if (n < d) {
            return -1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i - 1]);
        }
        for (int day = 2; day <= d; day++) {
            for (int to = n; to >= day; to--) {
                int curMax = 0;
                dp[to] = Integer.MAX_VALUE;
                for (int from = to - 1; from >= day - 1; from--) {
                    curMax = Math.max(curMax, jobs[from]);
                    dp[to] = Math.min(dp[to], dp[from] + curMax);
                }
            }
        }
        return dp[n];
    }

    // 2D
    public int minDifficulty(int[] jobs, int d) {
        int n = jobs.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d][n];
        int maxDifficulty = 0;
        for (int i = 0; i <= n - d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobs[i]);
            dp[0][i] = maxDifficulty;
        }
        for (int day = 1; day < d; day++) {
            for (int to = day; to <= n - d + day; to++) {
                int curDifficulty = jobs[to];
                int result = Integer.MAX_VALUE;
                for (int from = to - 1; from >= day - 1; from--) {
                    result = Math.min(result, dp[day - 1][from] + curDifficulty);
                    curDifficulty = Math.max(curDifficulty, jobs[from]);
                }
                dp[day][to] = result;
            }
        }
        return dp[d - 1][n - 1];
    }
}