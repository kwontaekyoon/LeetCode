class DFS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final var map = new HashMap<Integer, List<Integer>>();
        for (var e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<Integer>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<Integer>()).add(e[0]);
        }
        final var visit = new HashSet<Integer>();
        final var stack = new ArrayDeque<Integer>();
        stack.offerLast(source);
        while (!stack.isEmpty()) {
            var curr = stack.pollLast();
            if (curr == destination) {
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
}

class Dijkstra {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final var graph = new HashMap<Integer, List<Integer>>();
        for (var e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        
        final var distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        
        final var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, source});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDistance = current[0];
            int currentNode = current[1];
            
            if (currentNode == destination) {
                return true;
            }
            
            if (currentDistance > distances[currentNode]) {
                continue;
            }
            
            for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int distance = currentDistance + 1; // Assuming unweighted graph
                if (distance < distances[neighbor]) {
                    distances[neighbor] = distance;
                    pq.offer(new int[] {distance, neighbor});
                }
            }
        }
        
        return false;
    }
}