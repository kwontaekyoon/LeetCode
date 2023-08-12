class Solution {
    public int uniquePathsWithObstacles(int[][] map) {
        if (map[0][0] == 1)
            return 0;
        int r = map.length, c = map[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < c; i++) {
            if (map[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < r; i++) {
            if (map[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (map[i][j] == 0)
                    dp[i][j] += (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[r - 1][c - 1];
    }
}