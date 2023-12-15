class Solution {
    public int minDistance(String word1, String word2) {
        final int R = word1.length(), C = word2.length();
        final char[] word1ToChars = word1.toCharArray();
        final char[] word2ToChars = word2.toCharArray();
        final int[][] dp = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            dp[r][0] = r;
        }
        for (int c = 1; c <= C; c++) {
            dp[0][c] = c;
        }
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (word1ToChars[r - 1] == word2ToChars[c - 1]) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                }
            }
        }
        return dp[R][C];
    }
}