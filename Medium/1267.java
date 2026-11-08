class Solution {
    public int countServers(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            int rowSum = 0;
            for (int c = 0; c < n; c++) {
                rowSum += grid[r][c];
            }
            if (rowSum > 1) {
                res += rowSum;
            } else if (rowSum == 1) {
                int idx = -1;
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 1) {
                        idx = c;
                        break;
                    }
                }
                int colSum = 0;
                for (int i = 0; i < m; i++) {
                    colSum += grid[i][idx];
                }
                if (colSum > 1) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
