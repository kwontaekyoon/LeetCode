class Solution {
    public int[][] matrixReshape(int[][] mat, int nr, int nc) {
        final int or = mat.length, oc = mat[0].length;
        if (or * oc != nr * nc) {
            return mat;
        }
        final var res = new int[nr][nc];
        int dr = 0, dc = 0;
        for (int r = 0; r < or; r++) {
            for (int c = 0; c < oc; c++) {
                res[dr][dc] = mat[r][c];
                dc++;
                if (dc == nc) {
                    dr++;
                    dc = 0;
                }
            }
        }
        return res;
    }
}