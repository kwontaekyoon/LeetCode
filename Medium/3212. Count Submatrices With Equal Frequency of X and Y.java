class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] prefixX = new int[rows + 1][cols + 1];
        int[][] prefixY = new int[rows + 1][cols + 1];
        int count = 0;
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                prefixX[r][c] = prefixX[r - 1][c] + prefixX[r][c - 1] - prefixX[r - 1][c - 1];
                prefixY[r][c] = prefixY[r - 1][c] + prefixY[r][c - 1] - prefixY[r - 1][c - 1];
                if (grid[r - 1][c - 1] == 'X') {
                    prefixX[r][c]++;
                } else if (grid[r - 1][c - 1] == 'Y') {
                    prefixY[r][c]++;
                }
                if (prefixX[r][c] > 0 && prefixX[r][c] == prefixY[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}


class Solution1 {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] diffs = new int[rows][cols];
        boolean[][] isXIn = new boolean[rows][cols];
        // check if X is in for each pos
        if (grid[0][0] == 'X') {
            isXIn[0][0] = true;
        }
        for (int r = 1; r < rows; r++) {
            isXIn[r][0] = isXIn[r - 1][0] || (grid[r][0] == 'X');
        }
        for (int c = 1; c < cols; c++) {
            isXIn[0][c] = isXIn[0][c - 1] || (grid[0][c] == 'X');
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                isXIn[r][c] = isXIn[r - 1][c] || isXIn[r][c - 1] || (grid[r][c] == 'X');
            }
        }
        // for (var row : isXIn) {
        //     System.out.println(Arrays.toString(row));
        // }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 'X') {
                    diffs[r][c] = 1; 
                } else if (grid[r][c] == 'Y') {
                    diffs[r][c] = -1;
                }
            }
        }
        // column-wise prefix sums
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                diffs[r][c] += diffs[r][c - 1];
            }
        }
        // row-wise prefix sums
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                diffs[r][c] += diffs[r - 1][c];
            }
        }
        // Arrays.stream(diffs).forEach(row -> System.out.println(Arrays.toString(row)));
        // for (var row : diffs) {
        //     System.out.println(Arrays.toString(row));
        // }
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isXIn[r][c] && diffs[r][c] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
