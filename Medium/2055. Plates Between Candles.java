class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        final var chars = s.toCharArray();
        final int n = chars.length, m = queries.length;
        final var prefix = new int[n];
        int i = 0;
        while (i < n && chars[i] != '|') {
            i++;
        }
        int unclosed = 0, closed = 0;
        while (i < n) {
            if (chars[i] == '|') {
                closed += unclosed;
                unclosed = 0;
            } else {
                unclosed++;
            }
            prefix[i] = closed;
            i++;
        }
        final var closestBiggerCandles = new int[n];
        int candle = n - 1;
        while (candle >= 0 && chars[candle] != '|') {
            closestBiggerCandles[candle] = -1;
            candle--;
        }
        for (int j = candle, c = candle; j >= 0; j--) {
            if (chars[j] == '|') {
                c = j;
            }
            closestBiggerCandles[j] = c;
        }
        final var res = new int[m];
        for (int j = 0; j < m; j++) {
            int l = queries[j][0], r = queries[j][1];
            if (closestBiggerCandles[l] < 0) {
                continue;
            }
            l = Math.min(r, closestBiggerCandles[l]);
            res[j] = prefix[r] - prefix[l];
        }
        return res;
    }
}