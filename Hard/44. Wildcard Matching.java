class Solution {
    public boolean isMatch(String s, String p) {
        final char[] S = s.toCharArray(), P = p.toCharArray();
        final int N = S.length, M = P.length;
        final var DP = new boolean[N + 1][M + 1];
        DP[0][0] = true;
        for (int i = 0; i < M; i++) {
            if (!DP[0][i]) {
                break;
            }
            if (P[i] == '*') {
                DP[0][i + 1] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (S[i] == P[j] || P[j] == '?') {
                    DP[i + 1][j + 1] = DP[i][j];
                } else if (P[j] == '*') {
                    DP[i + 1][j + 1] = DP[i][j + 1] || DP[i + 1][j];
                }
            }
        }
        return DP[N][M];
    }
}