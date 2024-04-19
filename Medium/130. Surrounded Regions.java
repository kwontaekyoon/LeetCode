class Better {
    public void solve(char[][] board) {
        final int R = board.length, C = board[0].length;
        final var visit = new int[R][C];
        for (int r = 0; r < R; r++) {
            if (board[r][0] == 'O' && visit[r][0] == 0) {
                dfs(board, visit, R, C, r, 0);
            }
            if (board[r][C - 1] == 'O' && visit[r][C - 1] == 0) {
                dfs(board, visit, R, C, r, C - 1);
            }
        }
        for (int c = 0; c < C; c++) {
            if (board[0][c] == 'O' && visit[0][c] == 0) {
                dfs(board, visit, R, C, 0, c);
            }
            if (board[R - 1][c] == 'O' && visit[R - 1][c] == 0) {
                dfs(board, visit, R, C, R - 1, c);
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O' && visit[r][c] == 0) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] visit, int R, int C, int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C || visit[r][c] != 0 || board[r][c] == 'X') {
            return;
        }
        visit[r][c] = 1;
        dfs(board, visit, R, C, r - 1, c);
        dfs(board, visit, R, C, r + 1, c);
        dfs(board, visit, R, C, r, c - 1);
        dfs(board, visit, R, C, r, c + 1);
    }
}

class FirstSolution {
    public void solve(char[][] M) {
        final int R = M.length, C = M[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (M[r][c] == 'O') {
                    if (dfs(M, R, C, r, c)) {
                        fill(M, R, C, r, c);
                    }
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (M[r][c] == '£') {
                    M[r][c] = 'O';
                }
            }
        }
    }
    private boolean dfs(char[][] M, int R, int C, int r, int c) {
        boolean res = true;
        var stack = new ArrayDeque<int[]>();
        stack.offerLast(new int[] { r, c });
        while (!stack.isEmpty()) {
            var curr = stack.pollLast();
            int cr = curr[0], cc = curr[1];
            if (cr < 0 || cc < 0 || cr >= R || cc >= C) {
                res = false;
                continue;
            }
            if (M[cr][cc] != 'O') {
                continue;
            }
            M[cr][cc] = '£';
            stack.offerLast(new int[] { cr - 1, cc });
            stack.offerLast(new int[] { cr + 1, cc });
            stack.offerLast(new int[] { cr, cc - 1 });
            stack.offerLast(new int[] { cr, cc + 1 });
        }
        return res;
    }

    private void fill(char[][] M, int R, int C, int r, int c) {
        var stack = new ArrayDeque<int[]>();
        stack.offerLast(new int[] { r, c });
        while (!stack.isEmpty()) {
            var curr = stack.pollLast();
            int cr = curr[0], cc = curr[1];
            if (cr < 0 || cc < 0 || cr >= R || cc >= C || M[cr][cc] != '£') {
                continue;
            }
            M[cr][cc] = 'X';
            stack.offerLast(new int[] { cr - 1, cc });
            stack.offerLast(new int[] { cr + 1, cc });
            stack.offerLast(new int[] { cr, cc - 1 });
            stack.offerLast(new int[] { cr, cc + 1 });
        }
    }
}