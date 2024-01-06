class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        // start, end, profit
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (x, y) -> x[1] - y[1]);
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int start = jobs[i][0];
            int end = jobs[i][1];
            int value = jobs[i][2];
            int lastTime = bs(jobs, i, start);
            dp[i + 1] = Math.max(dp[i], dp[lastTime] + value);
        }
        return dp[n];
    }
    private int bs(int[][] jobs, int end, int target) {
        int l = 0;
        int r = end;
        while (l < r) {
            int m = (l + r) / 2;
            if (jobs[m][1] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
