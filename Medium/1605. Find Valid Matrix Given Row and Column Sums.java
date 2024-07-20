class Greedy {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        final int R = rowSum.length, C = colSum.length;
        final var matrix = new int[R][C];
        int r = 0, c = 0;
        while (r < R && c < C) {
            if (rowSum[r] < colSum[c]) {
                matrix[r][c] = rowSum[r];
                colSum[c] -= rowSum[r];
                rowSum[r] = 0;
                r++;
            } else {
                matrix[r][c] = colSum[c];
                rowSum[r] -= colSum[c];
                colSum[c] = 0;
                c++;
            }
        }
        return matrix;
    }
}

class Backtracking {
    int R, C;
    int[] rowSum, colSum;
    int[][] res;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        R = rowSum.length;
        C = colSum.length;
        this.rowSum = rowSum;
        this.colSum = colSum;
        res = new int[R][C];
        backtrack(0, 0);
        return res;
    }

    private boolean backtrack(int r, int c) {
        if (r == R) {
            return true;
        }
        if (c == C || rowSum[r] == 0) {
            return backtrack(r + 1, 0);
        }
        for (int i = Math.min(rowSum[r], colSum[c]); i >= 0; i--) {
            res[r][c] = i;
            rowSum[r] -= i;
            colSum[c] -= i;
            if (backtrack(r, c + 1)) {
                return true;
            }
            res[r][c] = 0;
            rowSum[r] += i;
            colSum[c] += i;
        }
        return false;
    }
}

class Solution {
    int R, C;
    int[] rowSum, colSum;
    int[][] res;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        R = rowSum.length;
        C = colSum.length;
        this.rowSum = rowSum;
        this.colSum = colSum;
        res = new int[R][C];
        dfs(0, 0);
        return res;
    }

    private void dfs(int r, int c) {
        if (r == R || c == C) {
            return;
        }
        if (rowSum[r] < colSum[c]) {
            res[r][c] = rowSum[r];
            colSum[c] -= rowSum[r];
            rowSum[r] = 0;
            dfs(r + 1, c);
        } else {
            res[r][c] = colSum[c];
            rowSum[r] -= colSum[c];
            colSum[c] = 0;
            dfs(r, c + 1);
        }
    }
}