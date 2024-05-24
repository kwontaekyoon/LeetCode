class Solution {
    private int maxScore = 0;
    private int N;
    private String[] WORDS;
    private int[] LETTERS;
    private int[] SCORE;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        WORDS = words;
        SCORE = score;
        N = words.length;
        LETTERS = new int[26];
        for (var c : letters) {
            LETTERS[c - 'a']++;
        }
        backtrack(0, 0);
        return maxScore;
    }

    private void backtrack(int i, int s) {
        maxScore = Math.max(maxScore, s);
        if (i == N) {
            return;
        }
        final var TMP = Arrays.copyOf(LETTERS, 26);
        int score = calculate(WORDS[i]);
        if (score > 0) {
            backtrack(i + 1, s + score);
        }
        LETTERS = TMP;
        backtrack(i + 1, s);
    }

    private int calculate(String s) {
        int sum = 0;
        for (var c : s.toCharArray()) {
            if (LETTERS[c - 'a'] > 0) {
                sum += SCORE[c - 'a'];
                LETTERS[c - 'a']--;
            } else {
                return -1;
            }
        }

        return sum;
    }
}