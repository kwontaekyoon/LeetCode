class DFS {
    public int islandPerimeter(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c, R, C);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c, int R, int C) {
        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] == -1) {
            return 0;
        }
        grid[r][c] = -1;
        return dfs(grid, r + 1, c, R, C) +
               dfs(grid, r - 1, c, R, C) +
               dfs(grid, r, c + 1, R, C) + 
               dfs(grid, r, c - 1, R, C);
    }
}

class Array {
    // final static int[] dirs = { -1, 0, 1, 0, -1 };
    public int islandPerimeter(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        int peri = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    // for (int d = 0; d < 4; d++) {
                    //     int nr = r + dirs[d], nc = c + dirs[d + 1];
                    //     if (nr < 0 || nc < 0 || nr >= R || nc >= C || grid[nr][nc] == 0) {
                    //         peri++;
                    //     }
                    // }
                    peri += 4;
                    if (r > 0 && grid[r - 1][c] == 1) {
                        peri -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1)  {
                        peri -= 2;
                    }
                }
            }
        }
        return peri;
    }
}

