class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] Rs = new boolean[matrix.length];
        boolean[] Cs = new boolean[matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    Rs[r] = true;
                    Cs[c] = true;
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (Rs[r] || Cs[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}