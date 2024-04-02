class Solution {

    private boolean isValid(char[][] board, int R, int C, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[R][i] == n || board[i][C] == n) {
                return false;
            }
        }

        R = R / 3 * 3;
        C = C / 3 * 3;
        for (int r = R; r < R + 3; r++) {
            for (int c = C; c < C + 3; c++) {
                if (board[r][c] == n) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {
        if (r == 9) {
            return true;
        }
        if (c == 9) {
            return backtrack(board, r + 1, 0);
        }
        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1);
        }

        for (char n = '1'; n <= '9'; n++) {
            if (isValid(board, r, c, n)) {
                board[r][c] = n;
                if (backtrack(board, r, c + 1)) {
                    return true;
                }
                board[r][c] = '.';
            }
        }

        return false;
    }
}