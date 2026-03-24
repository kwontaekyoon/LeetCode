class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] productMatrix = new int[rows][cols];
        long suffix = 1;
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                productMatrix[r][c] = (int) suffix;
                suffix = (suffix * grid[r][c]) % MOD;
            }
        }
        long prefix = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                productMatrix[r][c] = (int) (((long) productMatrix[r][c] * prefix) % MOD);
                prefix = (prefix * grid[r][c]) % MOD;
            }
        }
        return productMatrix;
    }
}
