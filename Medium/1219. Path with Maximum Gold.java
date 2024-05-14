class Solution1 {
    private int maxGold = 0;

    public int getMaximumGold(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] > 0) {
                    dfs(grid, new boolean[R][C], R, C, r, c, 0);
                }
            }
        }
        return maxGold;
    }

    private void dfs(int[][] grid, boolean[][] visited, int R, int C, int r, int c, int p) {
        if (r < 0 || c < 0 || r >= R || c >= C || visited[r][c] || grid[r][c] == 0) {
            return;
        }
        visited[r][c] = true;
        maxGold = Math.max(maxGold, p + grid[r][c]);
        dfs(grid, visited, R, C, r + 1, c, p + grid[r][c]);
        dfs(grid, visited, R, C, r - 1, c, p + grid[r][c]);
        dfs(grid, visited, R, C, r, c + 1, p + grid[r][c]);
        dfs(grid, visited, R, C, r, c - 1, p + grid[r][c]);
        visited[r][c] = false;
    }
}

class Solution {
    public int max = 0;

    public void ways(int[][] grid, int r, int c, int gold) {
        if (gold > max) {
            max = gold;
        }
        if (grid[r][c] == 0) {
            return;
        }
        int a = grid[r][c];
        grid[r][c] = 0;
        if (r - 1 >= 0) {
            ways(grid, r - 1, c, gold + a);
        }
        if (r + 1 <= grid.length - 1) {
            ways(grid, r + 1, c, gold + a);
        }
        if (c + 1 <= grid[0].length - 1) {
            ways(grid, r, c + 1, gold + a);
        }
        if (c - 1 >= 0) {
            ways(grid, r, c - 1, gold + a);
        }
        grid[r][c] = a;
    }

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ways(grid, i, j, 0);
            }
        }
        return max;
    }
}