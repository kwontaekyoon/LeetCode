class Solution {
    public int countSquares(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length, result = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 1 && r > 0 && c > 0) {
                    matrix[r][c] = Math.min(matrix[r - 1][c - 1], Math.min(matrix[r - 1][c], matrix[r][c - 1])) + 1;
                }
                result += matrix[r][c];
            }
        }
        return result;
    }
}