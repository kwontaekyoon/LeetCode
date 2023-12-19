class Solution {
    public int[][] imageSmoother(int[][] img) {
        final int R = img.length, C = img[0].length;
        final int[][] res = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int sum = 0;
                int cnt = 0;
                for (int x = Math.max(0, r - 1); x < Math.min(R, r + 2); x++) {
                    for (int y = Math.max(0, c - 1); y < Math.min(C, c + 2); y++) {
                        sum += img[x][y];
                        cnt += 1;
                    }
                }
                res[r][c] = sum / cnt;
            }
        }
        return res;
    }
}