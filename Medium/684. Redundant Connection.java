class Solution {
    class UnionFind {
        int[] parents;
        UnionFind(int n) {
            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }
        }
        int find(int child) {
            if (parents[child] == child) {
                return child;
            }
            return parents[child] = find(parents[child]);
        }
        boolean union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);
            if (uParent == vParent) {
                return false;
            }
            parents[uParent] = vParent;
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        final var UF = new UnionFind(edges.length);
        for (var edge: edges) {
            if (!UF.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}