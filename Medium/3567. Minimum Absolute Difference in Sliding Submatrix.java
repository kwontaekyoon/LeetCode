class Solution {

    public int[][] minAbsDiff(int[][] grid, int k) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        int[][] result = new int[rows - k + 1][cols - k + 1];

        if (k == 1) {
            return result;
        }

        for (int r = 0; r <= rows - k; r++) {
            for (int c = 0; c <= cols - k; c++) {
                result[r][c] = compute(grid, r, c, k);
            }
        }

        return result;
    }

    private int compute(int[][] grid, int startR, int startC, int size) {
        final int total = size * size;
        int[] nums = new int[total];

        int idx = 0;
        for (int r = startR; r < startR + size; r++) {
            for (int c = startC; c < startC + size; c++) {
                nums[idx++] = grid[r][c];
            }
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < total; i++) {
            int diff = nums[i] - nums[i - 1];

            if (diff == 0) {
                continue;
            }

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}


// class Solution1 {
//     private int[][] grid;
//     private int windowSize;

//     public int[][] minAbsDiff(int[][] grid, int k) {
//         this.grid = grid;
//         windowSize = k;
//         final int rows = grid.length;
//         final int cols = grid[0].length;
//         int[][] result = new int[rows - k + 1][cols - k + 1];
//         for (int r = 0; r < rows - k + 1; r++) {
//             for (int c = 0; c < cols - k + 1; c++) {
//                 result[r][c] = getMinAbsDiff(r, c);
//             }
//         }
//         return result;
//     }

//     private int getMinAbsDiff(int startingR, int startingC) {
//         final var hs = new HashSet<Integer>();
//         for (int r = startingR; r < startingR + windowSize; r++) {
//             for(int c = startingC; c < startingC + windowSize; c++) {
//                 hs.add(grid[r][c]);
//             }
//         }
//         if (hs.size() == 1) {
//             return 0;
//         }
//         final var list = hs.stream().sorted().toList();
//         int minAbsDiff = Integer.MAX_VALUE;
//         for (int i = 0; i < list.size() - 1; i++) {
//             minAbsDiff = Math.min(Math.abs(list.get(i + 1) - list.get(i)), minAbsDiff);
//         }
//         return minAbsDiff;
//     }
// }
