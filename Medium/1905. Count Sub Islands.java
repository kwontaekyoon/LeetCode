import java.util.ArrayDeque;

class Solution {
    private int R, C;
    private boolean isValid;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        R = grid1.length;
        C = grid1[0].length;
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid2[i][j] > 0) {
                    isValid = true;
                    dfs(i, j, grid1, grid2);
                    if (isValid) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private void dfs(int r, int c, int[][] grid1, int[][] grid2) {
        if (r < 0 || c < 0 || r >= R || c >= C || grid2[r][c] == 0) {
            return;
        }
        if (grid1[r][c] == 0) {
            isValid = false;
            return;
        }
        grid2[r][c] = 0;
        dfs(r + 1, c, grid1, grid2);
        dfs(r, c + 1, grid1, grid2);
        dfs(r - 1, c, grid1, grid2);
        dfs(r, c - 1, grid1, grid2);
    }
}

class TLE {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        final int m = grid1.length, n = grid1[0].length;
        final var common = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] > 0 && grid2[i][j] > 0) {
                    common[i][j] = 1;
                }
            }
        }
        final var visited = new boolean[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid2[i][j] == 0 || common[i][j] == 0) {
                    continue;
                }
                if (bfs(i, j, grid2, common, visited)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean bfs(int cr, int cc, int[][] grid, int[][] common, boolean[][] visited) {
        var isValid = true;
        final var queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { cr, cc });
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            if (common[curr[0]][curr[1]] == 0) {
                isValid = false;
            }
            if (curr[0] + 1 < grid.length && grid[curr[0] + 1][curr[1]] > 0 && !visited[curr[0] + 1][curr[1]]) {
                queue.offer(new int[] { curr[0] + 1, curr[1] });
            }
            if (curr[0] - 1 >= 0 && grid[curr[0] - 1][curr[1]] > 0 && !visited[curr[0] - 1][curr[1]]) {
                queue.offer(new int[] { curr[0] - 1, curr[1] });
            }
            if (curr[1] + 1 < grid[0].length && grid[curr[0]][curr[1] + 1] > 0 && !visited[curr[0]][curr[1] + 1]) {
                queue.offer(new int[] { curr[0], curr[1] + 1 });
            }
            if (curr[1] - 1 >= 0 && grid[curr[0]][curr[1] - 1] > 0 && !visited[curr[0]][curr[1] - 1]) {
                queue.offer(new int[] { curr[0], curr[1] - 1 });
            }
        }
        return isValid;
    }
}