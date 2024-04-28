class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        final var graph = new HashMap<Integer, List<Integer>>();
        final var count = new int[n];
        final var res = new int[n];
        Arrays.fill(count, 1);

        for (var E : edges) {
            graph.computeIfAbsent(E[0], k -> new ArrayList<>()).add(E[1]);
            graph.computeIfAbsent(E[1], k -> new ArrayList<>()).add(E[0]);
        }

        dfs1(graph, count, res, 0, -1);
        dfs2(graph, count, res, 0, -1);

        return res;
    }

    private void dfs1(Map<Integer, List<Integer>> graph, int[] count, int[] res, int node, int parent) {
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child != parent) {
                dfs1(graph, count, res, child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private void dfs2(Map<Integer, List<Integer>> graph, int[] count, int[] res, int node, int parent) {
        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child != parent) {
                res[child] = res[node] - count[child] + (count.length - count[child]);
                dfs2(graph, count, res, child, node);
            }
        }
    }
}