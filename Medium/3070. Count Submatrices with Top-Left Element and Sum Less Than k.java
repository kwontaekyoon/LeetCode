class Solution {

    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        buildPrefixSum(grid, rows, cols);

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    private void buildPrefixSum(int[][] grid, int rows, int cols) {
        // Row-wise prefix sum
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                grid[r][c] += grid[r][c - 1];
            }
        }

        // Column-wise prefix sum
        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                grid[r][c] += grid[r - 1][c];
            }
        }
    }
}
