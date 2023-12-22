class Solution {
    public int maxScore(String s) {
        final char[] sToChars = s.toCharArray();
        final int n = sToChars.length;
        int curScore = (sToChars[0] == '0') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            curScore += (sToChars[i] == '0') ? 0 : 1;
        }
        int maxScore = curScore;
        for (int i = 1; i < n - 1; i++) {
            curScore += (sToChars[i] == '0') ? 1 : -1;
            maxScore = Math.max(curScore, maxScore);
        }
        return maxScore;
    }
}