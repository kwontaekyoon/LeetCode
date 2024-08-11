class Solution {
    private int R, C;
    private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int minDays(int[][] grid) {
        this.R = grid.length;
        this.C = grid[0].length;
        if (countIslands(grid) != 1) {
            return 0;
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                grid[r][c] = 0;
                if (countIslands(grid) != 1) {
                    return 1;
                }
                grid[r][c] = 1;
            }
        }
        return 2;
    }

    private int countIslands(int[][] grid) {
        final var seen = new boolean[R][C];
        int islands = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1 && !seen[r][c]) {
                    islands++;
                    dfs(grid, r, c, seen);
                }
            }
        }
        return islands;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] seen) {
        seen[r][c] = true;
        for (var dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1 && !seen[nr][nc]) {
                dfs(grid, nr, nc, seen);
            }
        }
    }
}