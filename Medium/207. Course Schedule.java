// 나중에다시풀기 !!!!!!!!!!!!!!!
class DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses]; // 0 - not visited, 1 - visiting, 2 - visited

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, visited, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, int[] visited, List<List<Integer>> graph) {
        if (visited[course] == 1) {
            return true;
        }
        if (visited[course] == 2) {
            return false;
        }

        visited[course] = 1;
        for (int prerequisite : graph.get(course)) {
            if (hasCycle(prerequisite, visited, graph)) {
                return true;
            }
        }

        visited[course] = 2;
        return false;
    }
}

class BFS {
    public boolean canFinish(int N, int[][] prerequisites) {
        final var degree = new int[N];
        final var graph = new HashMap<Integer, List<Integer>>();
        for (var E : prerequisites) {
            degree[E[0]]++;
            graph.computeIfAbsent(E[1], k -> new ArrayList<>()).add(E[0]);
        }

        final var queue = new ArrayDeque<Integer>();
        int finished = 0;
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                finished++;
            }
        }
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int curr = queue.poll();
                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (--degree[next] == 0) {
                        finished++;
                        queue.offer(next);
                    }
                }
            }
        }

        return finished == N;
    }
}