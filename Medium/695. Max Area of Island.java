class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        int maxArea = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, R, C, r, c));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int R, int C, int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] == 0) {
            return 0;
        }
        if (grid[r][c] == -1) {
            return 0;
        }
        grid[r][c] = -1;
        return dfs(grid, R, C, r - 1, c) +
               dfs(grid, R, C, r + 1, c) + 
               dfs(grid, R, C, r, c - 1) +
               dfs(grid, R, C, r, c + 1) + 1;
    }
}