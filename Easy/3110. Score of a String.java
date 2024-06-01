class Solution {
    public int scoreOfString(String s) {
        final var chars = s.toCharArray();
        final var N = chars.length;
        int score = 0;
        for (int i = 1; i < N; i++) {
            score += Math.abs(chars[i] - chars[i - 1]);
        }
        return score;
    }
}