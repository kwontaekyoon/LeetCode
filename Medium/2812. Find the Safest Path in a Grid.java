class Solution {
    private final static int[] dirs = { 1, 0, -1, 0, 1 };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        final int N = grid.size();
        final var matrix = new int[N][N];
        final var queue = new ArrayDeque<int[]>();
        final var scores = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid.get(r).get(c) == 1) {
                    matrix[r][c] = 1;
                    queue.offer(new int[] { r, c });
                    scores[r][c] = 0;
                } else {
                    scores[r][c] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            int cr = curr[0], cc = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dirs[i], nc = cc + dirs[i + 1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || scores[nr][nc] <= scores[cr][cc] + 1) {
                    continue;
                }
                scores[nr][nc] = scores[cr][cc] + 1;
                queue.offer(new int[] { nr, nc });
            }
        }

        final var pq = new PriorityQueue<int[]>((x, y) -> Integer.compare(y[0], x[0]));
        pq.offer(new int[] { scores[0][0], 0, 0 });
        matrix[0][0] = 2;
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            int cs = curr[0], cr = curr[1], cc = curr[2];
            if (cr == N - 1 && cc == N - 1) {
                return cs;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cr + dirs[i], nc = cc + dirs[i + 1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || matrix[nr][nc] == 2) {
                    continue;
                }
                pq.offer(new int[] { Math.min(cs, scores[nr][nc]), nr, nc });
                matrix[nr][nc] = 2;
            }
        }
        return -1;
    }
}