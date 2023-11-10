class Solution {
    public int[] restoreArray(int[][] edges) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new LinkedList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new LinkedList<>()).add(edge[0]);
        }
        int[] seq = new int[edges.length + 1];
        int start = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        seq[0] = start;
        for (int i = 0; i < edges.length; i++) {
            List<Integer> edge = graph.get(seq[i]);
            if (edge.size() == 1) {
                seq[i + 1] = edge.get(0);
            } else {
                for (int j = 0; j < 2; j++) {
                    if (edge.get(j) != seq[i - 1]) {
                        seq[i + 1] = edge.get(j);
                        edge.remove(j);
                        break;
                    }
                }
            }
        }
        return seq;
    }
}
