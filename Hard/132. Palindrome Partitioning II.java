class Solution {
    public int minCut(String s) {
        final var S = s.toCharArray();
        final var N = S.length;
        final var DP = IntStream.range(0, N).toArray();

        for (int m = 0; m < N; m++) {
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int l = m, r = m; l >= 0 && r < N && S[l] == S[r]; l--, r++) {
                int newCutAtEnd = (l == 0) ? 0 : DP[l - 1] + 1;
                DP[r] = Math.min(DP[r], newCutAtEnd);
            }
            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int l = m - 1, r = m; l >= 0 && r < N && S[l] == S[r]; l--, r++) {
                int newCutAtEnd = (l == 0) ? 0 : DP[l - 1] + 1;
                DP[r] = Math.min(DP[r], newCutAtEnd);
            }
        }

        return DP[N - 1];
    }
}