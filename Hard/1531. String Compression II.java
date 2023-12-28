class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 9999;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int needRemove = 0;
                int groupCount = 0;
                for (int l = i; l > 0; l--) {
                    if (chars[l - 1] == chars[i - 1]) {
                        groupCount += 1;
                    } else {
                        needRemove += 1;
                    }
                    if (j - needRemove >= 0) {
                        if (groupCount == 1) {
                            dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - needRemove] + 1);
                        } else if (groupCount < 10) {
                            dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - needRemove] + 2);
                        } else if (groupCount < 100) {
                            dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - needRemove] + 3);
                        } else {
                            dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - needRemove] + 4);
                        }
                    }
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][k];
    }
}