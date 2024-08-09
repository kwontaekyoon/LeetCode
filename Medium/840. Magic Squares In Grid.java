class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        final int r = grid.length, c = grid[0].length;
        int res = 0;
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                if (isMagic(grid, i, j, sum)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagic(int[][] grid, int r, int c, int sum) {
        final var cnt = new int[10];
        for (int i = r + 2; i >= r; i--) {
            for (int j = c + 2; j >= c; j--) {
                if (grid[i][j] > 9 || grid[i][j] < 1) {
                    return false;
                }
                if (++cnt[grid[i][j]] > 1) {
                    return false;
                }
            }
        }
        for (int i = r + 1; i <= r + 2; i++) {
            if (sum != grid[i][c] + grid[i][c + 1] + grid[i][c + 2]) {
                return false;
            }
        }
        for (int j = c; j <= c + 2; j++) {
            if (sum != grid[r][j] + grid[r + 1][j] + grid[r + 2][j]) {
                return false;
            }
        }
        if (sum != grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]) {
            return false;
        }
        if (sum != grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) {
            return false;
        }
        return true;
    }
}