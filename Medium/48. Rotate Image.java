class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int r = 0; r < size / 2; r++) {
            int curSize = size - r * 2;
            for (int c = r; c < r + curSize - 1; c++) {
                int top = matrix[r][c]; // (1, 1)
                int right = matrix[c][size - 1 - r]; // (1, 2)
                int bottom = matrix[size - 1 - r][size - 1 - c]; // (2, 2)
                int left = matrix[size - 1 - c][r]; // (2, 1)
                matrix[r][c] = left;
                matrix[c][size - 1 - r] = top;
                matrix[size - 1 - r][size - 1 - c] = right;
                matrix[size - 1 - c][r] = bottom;
            }
        }
    }
}