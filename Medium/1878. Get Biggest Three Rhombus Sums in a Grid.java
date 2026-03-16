import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        final int R = grid.length, C = grid[0].length;
        final Set<Integer> set = new HashSet<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                set.add(grid[r][c]);
                for (int k = 1;; k++) {
                    int bottom = r + 2 * k;
                    int left = c - k;
                    int right = c + k;
                    if (bottom >= R || left < 0 || right >= C) {
                        break;
                    }
                    int rhombus = 0;
                    for (int t = 0; t < k; t++) {
                        rhombus += grid[r + t][c + t];
                    }
                    for (int t = 0; t < k; t++) {
                        rhombus += grid[r + k + t][c + k - t];
                    }
                    for (int t = 0; t < k; t++) {
                        rhombus += grid[r + 2 * k - t][c - t];
                    }
                    for (int t = 0; t < k; t++) {
                        rhombus += grid[r + k - t][c - k + t];
                    }
                    set.add(rhombus);
                }
            }
        }
        return set.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(i -> i).toArray();
    }
}