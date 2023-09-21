class Solution {
    private int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int cnt = 0;

    private void backtrack(int[][] grid, boolean[][] visited, int cr, int cc, int zeros) {
        if (grid[cr][cc] == 2 && zeros == -1) {
            cnt++;
        } else {
            for (int[] dir : dirs) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    backtrack(grid, visited, nr, nc, zeros - 1);
                    visited[nr][nc] = false;
                }
            }
        }
    }

    public int uniquePathsIII(int[][] grid) {
        int R = grid.length, C = grid[0].length, zeros = 0, sr = 0, sc = 0;
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 0) {
                    zeros++;
                } else if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                    visited[r][c] = true;
                } else if (grid[r][c] == -1) {
                    visited[r][c] = true;
                }
            }
        }
        backtrack(grid, visited, sr, sc, zeros);
        return cnt;
    }
}