import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
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
        final var graph = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        final var q = new ArrayDeque<Integer>();
        for (int[] c : A) {
            graph[c[0] - 1].add(c[1] - 1);
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
            for (int y : (List<Integer>) graph[x]) {
                if (--deg[y] == 0) {
                    q.add(y);
                }
            }
        }
        return order;
    }
}

class Solution1 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        final var rowGraph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            rowGraph[i] = new ArrayList<Integer>();
        }
        for (var rowCondition : rowConditions) {
            rowGraph[rowCondition[0]].add(rowCondition[1]);
        }

        final var colGraph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            colGraph[i] = new ArrayList<Integer>();
        }
        for (var colCondition : colConditions) {
            colGraph[colCondition[0]].add(colCondition[1]);
        }

        final var visited = new int[k + 1];
        final var queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= k; i++) {
            if (!topSort(rowGraph, i, visited, queue)) {
                return new int[0][0];
            }
        }

        final var rowIndexMap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowIndexMap[queue.pollLast()] = i;
        }

        Arrays.fill(visited, 0);
        queue.clear();
        for (int i = 1; i <= k; i++) {
            if (!topSort(colGraph, i, visited, queue)) {
                return new int[0][0];
            }
        }

        final var colIndexMap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            colIndexMap[queue.pollLast()] = i;
        }

        final var res = new int[k][k];
        for (int i = 1; i <= k; i++) {
            res[rowIndexMap[i]][colIndexMap[i]] = i;
        }

        return res;
    }

    private boolean topSort(List<Integer>[] graph, int node, int[] visited, Deque<Integer> queue) {
        if (visited[node] > 1) {
            return false;
        }
        if (visited[node] == 0) {
            visited[node] = 2;
            for (int child : graph[node]) {
                if (!topSort(graph, child, visited, queue)) {
                    return false;
                }
            }
            visited[node] = 1;
            queue.offerLast(node);
        }
        return true;
    }
}