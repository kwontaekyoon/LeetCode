class Solution {
    public int numIslands(char[][] grid) {
        final int R = grid.length, C = grid[0].length;
        int num = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    // dfs(grid, R, C, r, c);
                    bfs(grid, R, C, r, c);
                }
            }
        }
        return num;
    }

    private void bfs(char[][] grid, int R, int C, int r, int c) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { r, c });
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            int cr = curr[0], cc = curr[1];
            if (cr < 0 || cc < 0 || cr >= R || cc >= C || grid[cr][cc] != '1') {
                continue;
            }
            grid[cr][cc] = '0';
            queue.offer(new int[] { cr - 1, cc });
            queue.offer(new int[] { cr + 1, cc });
            queue.offer(new int[] { cr, cc - 1 });
            queue.offer(new int[] { cr, cc + 1 });
        }
    }

    private void dfs(char[][] grid, int R, int C, int r, int c) {
        var stack = new ArrayDeque<int[]>();
        stack.offerLast(new int[] { r, c });
        while (!stack.isEmpty()) {
            var curr = stack.pollLast();
            int cr = curr[0], cc = curr[1];
            if (cr < 0 || cc < 0 || cr >= R || cc >= C || grid[cr][cc] != '1') {
                continue;
            }
            grid[cr][cc] = '0';
            stack.offerLast(new int[] { cr - 1, cc });
            stack.offerLast(new int[] { cr + 1, cc });
            stack.offerLast(new int[] { cr, cc - 1 });
            stack.offerLast(new int[] { cr, cc + 1 });
        }
    }

    private void dfsRecursion(char[][] grid, int R, int C, int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '*';
        dfsRecursion(grid, R, C, r + 1, c);
        dfsRecursion(grid, R, C, r - 1, c);
        dfsRecursion(grid, R, C, r, c + 1);
        dfsRecursion(grid, R, C, r, c - 1);
    }
}