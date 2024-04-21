class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final var map = new HashMap<Integer, List<Integer>>();
        for (var e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<Integer>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<Integer>()).add(e[0]);
        }
        // return dfs(map, source, destination);
        // return bfs(map, source, destination);
        return dijkstra(map, source, destination, n);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int S, int D) {
        final var visit = new HashSet<Integer>();
        final var stack = new ArrayDeque<Integer>();
        stack.offerLast(S);
        while (!stack.isEmpty()) {
            var curr = stack.pollLast();
            if (curr == D) {
                return true;
            }
            if (!visit.add(curr)) {
                continue;
            }
            for (var next : map.get(curr)) {
                stack.offerLast(next);
            }
        }
        return false;
    }

    private boolean bfs(Map<Integer, List<Integer>> map, int S, int D) {
        final var queue = new ArrayDeque<Integer>();
        final var visit = new HashSet<Integer>();
        queue.offer(S);
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if (curr == D) {
                return true;
            }
            if (!visit.add(curr)) {
                continue;
            }
            for (var next : map.getOrDefault(curr, new ArrayList<>())) {
                queue.offer(next);
            }
        }
        return false;
    }

    private boolean dijkstra(Map<Integer, List<Integer>> map, int S, int D, int N) {
        final var distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        final var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, S});
        distances[S] = 0;
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            if (curr[1] == D) {
                return true;
            }
            for (int next : map.getOrDefault(curr[1], new ArrayList<>())) {
                if (curr[0] + 1 < distances[next]) {
                    pq.offer(new int[] { curr[0] + 1, next });
                    distances[next] = curr[0] + 1;
                }
            }
        }
        
        return false;
    }
}