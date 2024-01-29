class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int R = matrix.length, C = matrix[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 1; c < C; c++) {
                matrix[r][c] += matrix[r][c - 1];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int c1 = 0; c1 < C; c1++) {
            for (int c2 = c1; c2 < C; c2++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;
                for (int r = 0; r < R; r++) {
                    sum += matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);
                    cnt += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return cnt;
    }
}