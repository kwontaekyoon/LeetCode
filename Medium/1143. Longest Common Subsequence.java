class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        char[] text1ToChars = text1.toCharArray();
        char[] text2ToChars = text2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int r = 1; r <= len1; r++) {
            for (int c = 1; c <= len2; c++) {
                if (text1ToChars[r - 1] == text2ToChars[c - 1]) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}