class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int r = 1; r <= s1.length(); r++) {
            dp[r][0] = dp[r - 1][0] && s1.charAt(r - 1) == s3.charAt(r - 1);
        }
        for (int c = 1; c <= s2.length(); c++) {
            dp[0][c] = dp[0][c - 1] && s2.charAt(c - 1) == s3.charAt(c - 1);
        }
        for (int r = 1; r <= s1.length(); r++) {
            for (int c = 1; c <= s2.length(); c++) {
                dp[r][c] = (dp[r - 1][c] && s1.charAt(r - 1) == s3.charAt(r + c - 1)) ||
                        (dp[r][c - 1] && s2.charAt(c - 1) == s3.charAt(r + c - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}