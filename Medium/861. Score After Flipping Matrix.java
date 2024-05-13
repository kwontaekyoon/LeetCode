class Solution {
    public int matrixScore(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        for (int r = 0; r < R; r++) {
            if (grid[r][0] == 0) {
                updateRow(grid, C, r);
            }
        }
        int res = (1 << (C - 1)) * R;
        for (int c = 1; c < C; c++) {
            int cntOne = 0;
            for (int r = 0; r < R; r++) {
                cntOne += grid[r][c];
            }
            res += Math.max(cntOne, R - cntOne) * (1 << (C - 1 - c));
        }
        return res;
    }

    private void updateRow(int[][] grid, int C, int r) {
        for (int c = 0; c < C; c++) {
            grid[r][c] = grid[r][c] == 0 ? 1 : 0;
        }
    }
}

class BitManipulation {
    public int matrixScore(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        int res = (1 << (C - 1)) * R;

        for (int c = 1; c < C; c++) {
            int val = 1 << (C - 1 - c);
            int set = 0;

            for (int r = 0; r < R; r++) {
                if (grid[r][c] == grid[r][0]) {
                    set++;
                }
            }

            res += Math.max(set, R - set) * val;
        }

        return res;
    }
}