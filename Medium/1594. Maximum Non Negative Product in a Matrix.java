class Solution {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long MOD = 1000000007;
        long[][][] res = new long[rows][cols][2];
        res[0][0][0] = res[0][0][1] = grid[0][0];
        for (int r = 1; r < rows; r++) {
            res[r][0][0] = res[r][0][1] = res[r - 1][0][0] * grid[r][0];
        }
        for (int c = 1; c < cols; c++) {
            res[0][c][0] = res[0][c][1] = res[0][c - 1][0] * grid[0][c];
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                long x = grid[r][c];
                long a = res[r - 1][c][0] * x;
                long b = res[r - 1][c][1] * x;
                long d = res[r][c - 1][0] * x;
                long e = res[r][c - 1][1] * x;
                res[r][c][0] = Math.min(Math.min(a, b), Math.min(d, e));
                res[r][c][1] = Math.max(Math.max(a, b), Math.max(d, e));
            }
        }
        return res[rows - 1][cols - 1][1] < 0 ? -1 : (int) (res[rows - 1][cols - 1][1] % MOD);
    }
}
