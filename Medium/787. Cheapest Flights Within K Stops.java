class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { src, 0 });
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        while (k > -1 && !queue.isEmpty()) {
            k--;
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                for (int to = 0; to < n; to++) {
                    if (graph[cur[0]][to] != 0 && graph[cur[0]][to] + cur[1] < dp[to]) {
                        dp[to] = Math.min(dp[to], cur[1] + graph[cur[0]][to]);
                        if (to != dst) {
                            queue.offer(new int[] { to, cur[1] + graph[cur[0]][to] });
                        }
                    }
                }
            }
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}