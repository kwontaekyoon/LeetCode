// O(R * C)
class Solution {
    public long maxPoints(int[][] points) {
        final int C = points[0].length;
        var dp = new long[C];
        var tmp = new long[C];
        for (var row : points) {
            var max = 0L;
            for (int c = 0; c < C; c++) {
                max = Math.max(max - 1, dp[c]);
                tmp[c] = max;
            }
            max = 0L;
            for (int c = C - 1; c >= 0; c--) {
                max = Math.max(max - 1, dp[c]);
                tmp[c] = Math.max(tmp[c], max);
            }
            for (int c = 0; c < C; c++) {
                tmp[c] += row[c];
            }
            dp = tmp;
        }
        var res = 0L;
        for (var max : dp) {
            res = Math.max(res, max);
        }
        return res;
    }
}

// O(R * C * C)
class Solution1 {
    public long maxPoints(int[][] points) {
        final int R = points.length, C = points[0].length;
        var dp = new long[C];
        for (int c = 0; c < C; c++) {
            dp[c] = points[0][c];
        }
        for (int r = 1; r < R; r++) {
            var tmp = new long[C];
            for (int c = 0; c < C; c++) {
                var max = 0L;
                for (int t = 0; t < C; t++) {
                    max = Math.max(max, dp[t] - Math.abs(t - c));
                }
                tmp[c] = max + points[r][c];
            }
            dp = tmp;
        }
        var res = 0L;
        for (int c = 0; c < C; c++) {
            res = Math.max(res, dp[c]);
        }
        return res;
    }
}