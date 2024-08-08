class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        final var res = new int[rows * cols][2];
        int target = rows * cols, cn = 1;
        int cr = rStart, cc = cStart;
        res[cn - 1] = new int[] { cr, cc };
        out: for (int i = 1; i <= Math.max(rows, cols); i++) {
            cc++;
            if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                res[cn++] = new int[] { cr, cc };
                if (cn > target) {
                    break;
                }
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                cr++;
                if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                    res[cn++] = new int[] { cr, cc };
                    if (cn > target) {
                        break out;
                    }
                }
            }
            cc--;
            if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                res[cn++] = new int[] { cr, cc };
                if (cn > target) {
                    break;
                }
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                cc--;
                if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                    res[cn++] = new int[] { cr, cc };
                    if (cn > target) {
                        break out;
                    }
                }
            }
            cr--;
            if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                res[cn++] = new int[] { cr, cc };
                if (cn > target) {
                    break;
                }
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                cr--;
                if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                    res[cn++] = new int[] { cr, cc };
                    if (cn > target) {
                        break out;
                    }
                }
            }
            cc++;
            if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                res[cn++] = new int[] { cr, cc };
                if (cn > target) {
                    break;
                }
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                cc++;
                if (cc >= 0 && cc < cols && cr >= 0 && cr < rows) {
                    res[cn++] = new int[] { cr, cc };
                    if (cn > target) {
                        break out;
                    }
                }
            }
        }
        return res;
    }
}