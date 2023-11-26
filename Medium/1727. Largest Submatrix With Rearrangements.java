class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        for (int c = 0; c < C; c++) {
            for (int r = 1; r < R; r++) {
                if (matrix[r][c] == 0) {
                    continue;
                }
                matrix[r][c] += matrix[r - 1][c];
            }
        }
        int ans = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int c = C - 1, l = 1; c > -1 && row[c] > 0; c--, l++) {
                ans = Math.max(row[c] * l, ans);
            }
        }
        return ans;
    }
}