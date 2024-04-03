class FIRST {
    private final static int[] dirs = { 1, 0, -1, 0, 1 };
    private int R, C, N;
    private char[] W;
    private char[][] map;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        map = board;
        R = board.length;
        C = board[0].length;
        N = word.length();
        W = word.toCharArray();
        var found = false;
        for (int r = 0; r < R && !found; r++) {
            for (int c = 0; c < C && !found; c++) {
                if (board[r][c] == W[0]) {
                    visited = new boolean[R][C];
                    visited[r][c] = true;
                    found = backtrack(r, c, 0);
                }
            }
        }
        return found;
    }

    private boolean backtrack(int cr, int cc, int ci) {
        if (ci == N - 1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int nr = cr + dirs[i], nc = cc + dirs[i + 1];
            if (canGo(nr, nc) && map[nr][nc] == W[ci + 1]) {
                visited[nr][nc] = true;
                if (backtrack(nr, nc, ci + 1)) {
                    return true;
                }
                visited[nr][nc] = false;
            }
        }
        return false;
    }

    private boolean canGo(int r, int c) {
        return r > -1 && c > -1 && r < R && c < C && !visited[r][c];
    }
}

class SECOND {
    public boolean exist(char[][] board, String word) {
        final int R = board.length, C = board[0].length, N = word.length();
        final var V = new boolean[R][C];
        final var W = word.toCharArray();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == W[0]) {
                    if (backtrack(board, W, V, r, c, 0, R, C, N)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean backtrack(
        char[][] board, char[] word, boolean[][] visited,
        int r, int c, int i, int R, int C, int N
    ) {
        if (i == N) {
            return true;
        }
        if (r < 0 || c < 0 || r >= R || c >= C || 
            visited[r][c] || word[i] != board[r][c]
        ) {
            return false;
        }
        visited[r][c] = true;
        if (backtrack(board, word, visited, r + 1, c, i + 1, R, C, N) ||
            backtrack(board, word, visited, r - 1, c, i + 1, R, C, N) ||
            backtrack(board, word, visited, r, c + 1, i + 1, R, C, N) ||
            backtrack(board, word, visited, r, c - 1, i + 1, R, C, N)
        ) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }
}