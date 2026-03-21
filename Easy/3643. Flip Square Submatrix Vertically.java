class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int r = 0; r < k / 2; r++) {
            for (int c = 0; c < k; c++) {
                int temp = grid[x + r][y + c];
                grid[x + r][y + c] = grid[x + k - 1 - r][y + c];
                grid[x + k - 1 - r][y + c] = temp;
            }
        }
        return grid;
    }
}
