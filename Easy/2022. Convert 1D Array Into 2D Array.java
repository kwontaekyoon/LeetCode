import java.util.Arrays;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][];
        }
        final var res = new int[m][];
        for (int r = 0; r < m; r++) {
            res[r] = Arrays.copyOfRange(original, r * n, r * n + n);
        }
        return res;
    }
}