class Solution {
    public int numSpecial(int[][] mat) {
        final int R = mat.length, C = mat[0].length;
        int[] flatRow = new int[R];
        int[] flatCol = new int[C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                flatRow[r] += mat[r][c];
                flatCol[c] += mat[r][c];
            }
        }
        int numOfSpecial = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (mat[r][c] == 1) {
                    if (flatRow[r] == 1 && flatCol[c] == 1) {
                        numOfSpecial += 1;
                    }
                }
            }
        }
        return numOfSpecial;
    }
}