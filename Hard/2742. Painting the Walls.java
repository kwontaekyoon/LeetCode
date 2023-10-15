class tabulation {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length, dp[] = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
            }
        }
        return dp[n];
    }
}

class memo {
    private int dfs(int[] cost, int[] time, int index, int remain, int[][] dp) {
        if (remain <= 0)
            return 0;
        if (index >= cost.length)
            return (int) 1e9;
        if (dp[index][remain] != -1)
            return dp[index][remain];
        int take = cost[index] + dfs(cost, time, index + 1, remain - 1 - time[index], dp);
        int notTake = dfs(cost, time, index + 1, remain, dp);
        return dp[index][remain] = Math.min(take, notTake);
    }

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(cost, time, 0, n, dp);
    }
}