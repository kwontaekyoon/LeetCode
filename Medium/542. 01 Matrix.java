class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (mat[r][c] == 0) {
                    q.offer(new int[] { r, c });
                } else {
                    mat[r][c] = R * C;
                }
            }
        }
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int[] d : dir) {
                int r = now[0] + d[0], c = now[1] + d[1];
                if (r >= 0 && c >= 0 && r < R && c < C && mat[r][c] > mat[now[0]][now[1]] + 1) {
                    q.offer(new int[] { r, c });
                    mat[r][c] = mat[now[0]][now[1]] + 1;
                }
            }
        }
        return mat;
    }
}