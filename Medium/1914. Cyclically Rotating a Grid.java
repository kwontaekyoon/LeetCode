class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int T = 0, L = 0;
        int B = grid.length - 1, R = grid[0].length - 1;
        while (T < B && L < R) {
            // 1st
            int len = B - T, wid = R - L;
            int rot = k % (2 * len + 2 * wid);
            while (rot-- > 0) {
                int tmp = grid[T][L];
                for (int c = L; c < R; c++) {
                    grid[T][c] = grid[T][c + 1];
                }
                for (int r = T; r < B; r++) {
                    grid[r][R] = grid[r + 1][R];
                }
                for (int c = R; c > L; c--) {
                    grid[B][c] = grid[B][c - 1];
                }
                for (int r = B; r > T + 1; r--) {
                    grid[r][L] = grid[r - 1][L];
                }
                grid[T + 1][L] = tmp;
            }
            T++; L++; B--; R--;
            // 2nd
            // List<Integer> nums = new ArrayList<>();
            // for (int c = L; c < R; c++) {
            //     nums.add(grid[T][c]);
            // }
            // for (int r = T; r < B; r++) {
            //     nums.add(grid[r][R]);
            // }
            // for (int c = R; c > L; c--) {
            //     nums.add(grid[B][c]);
            // }
            // for (int r = B; r > T; r--) {
            //     nums.add(grid[r][L]);
            // }
            // int rot = k % nums.size();
            // Collections.rotate(nums, -rot);
            // int i = 0;
            // for (int c = L; c < R; c++) {
            //     grid[T][c] = nums.get(i++);
            // }
            // for (int r = T; r < B; r++) {
            //     grid[r][R] = nums.get(i++);
            // }
            // for (int c = R; c > L; c--) {
            //     grid[B][c] = nums.get(i++);
            // }
            // for (int r = B; r > T; r--) {
            //     grid[r][L] = nums.get(i++);
            // }
            // T++; L++; B--; R--;
        }
        return grid;
    }
}
