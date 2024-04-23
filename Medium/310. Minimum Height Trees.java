class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        final var graph = new HashMap<Integer, List<Integer>>();
        final var degree = new int[n];
        for (var E : edges) {
            degree[E[0]]++;
            degree[E[1]]++;
            graph.computeIfAbsent(E[0], k -> new ArrayList<>()).add(E[1]);
            graph.computeIfAbsent(E[1], k -> new ArrayList<>()).add(E[0]);
        }

        final var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] < 2) {
                queue.offer(i);
            }
        }

        var res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                res.add(curr);
                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (--degree[next] == 1)  {
                        queue.offer(next);
                    }
                }
            }
        }

        return res;
    }
}

// naive approach -> time limit exceeded
class BFS {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        final var map = new HashMap<Integer, List<Integer>>();
        for (var E : edges) {
            map.computeIfAbsent(E[0], k -> new ArrayList<>()).add(E[1]);
            map.computeIfAbsent(E[1], k -> new ArrayList<>()).add(E[0]);
        }

        int min = Integer.MAX_VALUE;
        var res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int currMin = bfs(i, map);
            if (currMin < min) {
                min = currMin;
                res = new ArrayList<Integer>();
                res.add(i);
            } else if (currMin == min) {
                res.add(i);
            }
        }
        return res;
    }
    private int bfs(int start, Map<Integer, List<Integer>> map) {
        final var queue = new ArrayDeque<Integer>();
        final var visit = new HashSet<Integer>();
        int depth = 0;
        queue.offer(start);
        visit.add(start);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int curr = queue.poll();
                for (int next : map.getOrDefault(curr, new ArrayList<>())) {
                    if (visit.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}