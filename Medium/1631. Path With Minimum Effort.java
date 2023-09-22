// backtracking -> time limit exceeded
// class Solution {
//     private int minEffort = Integer.MAX_VALUE, R = 0, C = 0;
//     private int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

//     private void backtrack(int cr, int cc, int currEffort, int[][] heights, int[][] dists) {
//         if (cr == R - 1 && cc == C - 1) {
//             minEffort = currEffort;
//         } else {
//             for (int[] dir : dirs) {
//                 int nr = cr + dir[0], nc = cc + dir[1];
//                 if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
//                     int newEffort = Math.max(Math.abs(heights[nr][nc] - heights[cr][cc]), currEffort);
//                     if (newEffort < dists[nr][nc]) {
//                         dists[nr][nc] = newEffort;
//                         backtrack(nr, nc, newEffort, heights, dists);
//                     }
//                 }
//             }
//         }
//     }
//     public int minimumEffortPath(int[][] heights) {
//         R = heights.length;
//         C = heights[0].length;
//         int[][] dists = new int[R][C];
//         for (int[] dist : dists) {
//             Arrays.fill(dist, Integer.MAX_VALUE);
//         }
//         dists[0][0] = 0;
//         backtrack(0, 0, 0, heights, dists);
//         return minEffort;
//     }
// }

// dijkstra -> shortest path from a graph of weighted nodes
public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] { 0, 0, 0 });

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];

            if (x == rows - 1 && y == cols - 1) {
                return effort;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (new_effort < dist[nx][ny]) {
                        dist[nx][ny] = new_effort;
                        minHeap.add(new int[] { new_effort, nx, ny });
                    }
                }
            }
        }
        return -1;
    }
}