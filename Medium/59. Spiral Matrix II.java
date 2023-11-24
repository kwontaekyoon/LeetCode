class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int r = 0, c = 0, d = 0, num = 1;
        while (num <= n * n) {
            matrix[r][c] = num++;
            if (!canGo(r, c, d, dirs, matrix)) {
                d = (d + 1) % 4;
            }
            r += dirs[d][0];
            c += dirs[d][1];
        }
        return matrix;
    }

    private boolean canGo(int r, int c, int d, int[][] dirs, int[][] matrix) {
        if (r + dirs[d][0] < 0 || r + dirs[d][0] >= matrix.length) {
            return false;
        }
        if (c + dirs[d][1] < 0 || c + dirs[d][1] >= matrix.length) {
            return false;
        }
        if (matrix[r + dirs[d][0]][c + dirs[d][1]] != 0) {
            return false;
        }
        return true;
    }
}