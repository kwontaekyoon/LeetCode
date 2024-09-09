import java.util.Arrays;

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        final var mat = new int[m][n];
        for (var row : mat) {
            Arrays.fill(row, -1);
        }
        int minR = 0, maxR = m - 1, minC = 0, maxC = n - 1;
        while (head != null) {
            for (int c = minC; head != null && c <= maxC; c++, head = head.next) {
                mat[minR][c] = head.val;
            }
            minR++;
            for (int r = minR; head != null && r <= maxR; r++, head = head.next) {
                mat[r][maxC] = head.val;
            }
            maxC--;
            for (int c = maxC; head != null && c >= minC; c--, head = head.next) {
                mat[maxR][c] = head.val;
            }
            maxR--;
            for (int r = maxR; head != null && r >= minR; r--, head = head.next) {
                mat[r][minC] = head.val;
            }
            minC++;
        }
        return mat;
    }
}

class Solution1 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        final var dirs = new int[] { 0, 1, 0, -1, 0 };
        final var matrix = new int[m][n];
        for (var row : matrix) {
            Arrays.fill(row, -1);
        }
        for (int r = 0, c = 0, d = 0; head != null; head = head.next) {
            matrix[r][c] = head.val;
            int nr = r + dirs[d], nc = c + dirs[d + 1];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n || matrix[nr][nc] != -1) {
                d = (d + 1) % 4;
                nr = r + dirs[d];
                nc = c + dirs[d + 1];
            }
            r = nr;
            c = nc;
        }
        return matrix;
    }
}