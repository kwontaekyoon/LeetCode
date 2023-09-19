class Solution {
    public int minDistance(String word1, String word2) {
        // longest common sequences
        int len1 = word1.length(), len2 = word2.length();
        // int[][] dp = new int[len1 + 1][len2 + 1];
        // for (int r = 1; r <= len1; r++) {
        // for (int c = 1; c <= len2; c++) {
        // if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
        // dp[r][c] = dp[r - 1][c - 1] + 1;
        // } else {
        // dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
        // }
        // }
        // }
        // return len1 + len2 - 2 * dp[len1][len2];

        // 1d
        int[] dp = new int[len2 + 1];
        int[] tmp = new int[len2 + 1];

        for (int i = 1; i <= len1; i++) {
            tmp = new int[len2 + 1];
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    tmp[j] = dp[j - 1] + 1;
                } else {
                    tmp[j] = Math.max(dp[j], tmp[j - 1]);
                }
            }
            dp = tmp;
        }

        return len1 + len2 - 2 * dp[len2];
    }
}