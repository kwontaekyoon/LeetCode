class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            // check rows
            if (!isRowValid(board, row)) {
                return false;
            }
            // check cols
            if (!isColValid(board, row)) {
                return false;
            }
            for (int col = 0; col < 9; col++) {
                // check boxes
                if (row % 3 == 0 && col % 3 == 0) {
                    if (!isBoxValid(board, row, col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isRowValid(char[][] board, int row) {
        boolean[] isIn = new boolean[9];
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') {
                continue;
            } else if (isIn[board[row][col] - '1']) {
                return false;
            } else {
                isIn[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    public boolean isColValid(char[][] board, int col) {
        boolean[] isIn = new boolean[9];
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == '.') {
                continue;
            } else if (isIn[board[row][col] - '1']) {
                return false;
            } else {
                isIn[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    public boolean isBoxValid(char[][] board, int startRow, int startCol) {
        boolean[] isIn = new boolean[9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[startRow + row][startCol + col] == '.') {
                    continue;
                } else if (isIn[board[startRow + row][startCol + col] - '1']) {
                    return false;
                } else {
                    isIn[board[startRow + row][startCol + col] - '1'] = true;
                }
            }
        }
        return true;
    }
}