class Solution {
    private final static int MOD = (int) 1e9 + 7;
    private int[] dir = { -1, 0, 1, 0, -1 };

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int[][] sum = new int[m][n];
        sum[startRow][startColumn] = 1;
        int numOfPaths = 0;
        for (int move = 0; move < maxMove; move++) {
            int[][] cur = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dir[i];
                        int nc = c + dir[i + 1];
                        if (isValid(m, n, nr, nc)) {
                            cur[nr][nc] = (cur[nr][nc] + sum[r][c]) % MOD;
                        } else {
                            numOfPaths = (numOfPaths + sum[r][c]) % MOD;
                        }
                    }
                }
            }
            sum = cur;
        }
        return numOfPaths;
    }

    private boolean isValid(int R, int C, int r, int c) {
        return r > -1 && c > -1 && r < R && c < C;
    }
}