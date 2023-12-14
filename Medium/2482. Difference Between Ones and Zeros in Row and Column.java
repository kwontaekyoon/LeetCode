class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        // diff[r][c] = onesRow(r) - zerosRow(r) (R - onesRow(r)) + onesCol(c) -
        // zerosCol(c)
        final int R = grid.length, C = grid[0].length;
        int[] onesRow = new int[R];
        int[] onesCol = new int[C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                onesRow[r] += grid[r][c];
                onesCol[c] += grid[r][c];
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                grid[r][c] = (2 * onesRow[r] - R) + (2 * onesCol[c] - C);
            }
        }
        return grid;
    }
}