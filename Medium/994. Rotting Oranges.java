class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Deque<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0, R = grid.length, C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    freshOranges++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[] { r, c });
                }
            }
        }
        int min = 0;
        while (!queue.isEmpty()) {
            boolean flag = false;
            for (int i = queue.size(); i > 0; i--) {
                int[] rottenOrange = queue.poll();
                for (int[] dir : dirs) {
                    int nr = rottenOrange[0] + dir[0];
                    int nc = rottenOrange[1] + dir[1];
                    if (nr > -1 && nc > -1 && nr < R && nc < C) {
                        if (grid[nr][nc] == 1) {
                            flag = true;
                            grid[nr][nc] = 2;
                            freshOranges--;
                            queue.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
            if (flag) {
                min++;
            }
        }
        return freshOranges == 0 ? min : -1;
    }
}

