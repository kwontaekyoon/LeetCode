class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int k = 0; k < 4; k++) {
            if (isMatching(mat, target)) {
                return true;
            }
            mat = rotate(mat);
        }
        return false;
    }
    private boolean isMatching(int[][] A, int[][] B) {
        for (int r = 0; r < A.length; r++) {
            if (!Arrays.equals(A[r], B[r])) {
                return false;
            }
        }
        return true;
    }
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        for (int[] row : mat) {
            for (int i = 0; i < n / 2; i++) {
                int tmp = row[i];
                row[i] = row[n - 1 - i];
                row[n - 1 - i] = tmp;
            }
        }
        return mat;
    }
}
