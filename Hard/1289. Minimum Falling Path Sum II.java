class Solution {
    public int minFallingPathSum(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int c = 0; c < C; c++) {
            if (grid[0][c] < smallest) {
                secondSmallest = smallest;
                smallest = grid[0][c];
            } else if (grid[0][c] < secondSmallest) {
                secondSmallest = grid[0][c];
            }
        }
        for (int r = 1; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r - 1][c] == smallest) {
                    grid[r][c] += secondSmallest;
                } else {
                    grid[r][c] += smallest;
                }
            }
            smallest = Integer.MAX_VALUE;
            secondSmallest = Integer.MAX_VALUE;
            for (int c = 0; c < C; c++) {
                if (grid[r][c] < smallest) {
                    secondSmallest = smallest;
                    smallest = grid[r][c];
                } else if (grid[r][c] < secondSmallest) {
                    secondSmallest = grid[r][c];
                }
            }
        }
        return Arrays.stream(grid[R - 1]).min().getAsInt();
    }
}