class Solution {
    public int[][] largestLocal(int[][] grid) {
        final int N = grid.length;
        final var res = new int[N - 2][N - 2];
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2; j++) {
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        res[i][j] = Math.max(res[i][j], grid[r][c]);
                    }
                }
            }
        }
        return res;
    }
}