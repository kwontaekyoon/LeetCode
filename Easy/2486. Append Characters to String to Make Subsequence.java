class Solution {
    public int appendCharacters(String s, String t) {
        final var S = s.toCharArray();
        final var T = t.toCharArray();
        final int N = S.length, M = T.length;
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (S[i] == T[j]) {
                j++;
            }
            i++;
        }
        return M - j;
    }
}