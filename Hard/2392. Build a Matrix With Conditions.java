import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        final var order1 = GenerateTopologicalSort(rowConditions, k);
        final var order2 = GenerateTopologicalSort(colConditions, k);
        if (order1.size() < k || order2.size() < k) {
            return new int[0][0];
        }
        final var m = new int[k + 1];
        for (int i = 0; i < k; i++) {
            m[order2.get(i)] = i;
        }
        final var ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            ans[i][m[order1.get(i)]] = order1.get(i);
        }
        return ans;
    }

    private List<Integer> GenerateTopologicalSort(int[][] A, int k) {
        final var deg = new int[k];
        final var order = new ArrayList<Integer>();
        final var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<Integer>());
        }
        final var q = new ArrayDeque<Integer>();
        for (int[] c : A) {
            graph.get(c[0] - 1).add(c[1] - 1);
            deg[c[1] - 1]++;
        }
        for (int i = 0; i < k; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            order.add(x + 1);
            for (int y : graph.get(x)) {
                if (--deg[y] == 0) {
                    q.add(y);
                }
            }
        }
        return order;
    }
}