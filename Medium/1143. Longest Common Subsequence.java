class Solution {
    public int 2D(String text1, String text2) {
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

    public int 1D(String text1, String text2) {
        if (text1.length() > text2.length()) {
            return helper(text1, text2);
        } else {
            return helper(text2, text1);
        }
    }
    private int helper(String longer, String shorer) {
        int longLen = longer.length(), shorLen = shorer.length();
        char[] L = longer.toCharArray(), S = shorer.toCharArray();
        int [] dp = new int[shorLen + 1];
        for (int r = 0; r < longLen; r++) {
            int[] tmp = new int[shorLen + 1];
            for (int c = 0; c < shorLen; c++) {
                if (L[r] == S[c]) {
                    tmp[c + 1] = dp[c] + 1;
                } else {
                    tmp[c + 1] = Math.max(tmp[c], dp[c + 1]);
                }
            }
            dp = tmp;
        }
        return dp[shorLen];
    }
}