// dijkstra -> shortest path from a graph of weighted nodes
public class Solution {
    private class Node {
        private int r;
        private int c;
        private int effort;

        private Node(int r, int c, int effort) {
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));
        minHeap.offer(new Node(0, 0, 0));
        while (!minHeap.isEmpty()) {
            Node top = minHeap.poll();
            int effort = top.effort, r = top.r, c = top.c;
            if (r == rows - 1 && c == cols - 1) {
                return effort;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));
                if (newEffort < dist[nr][nc]) {
                    dist[nr][nc] = newEffort;
                    minHeap.offer(new Node(nr, nc, newEffort));
                }
            }
        }
        return -1;
    }
}