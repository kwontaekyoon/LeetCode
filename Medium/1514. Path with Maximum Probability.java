import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution1 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        final var dists = new double[n];
        dists[start] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            var updated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                var p = succProb[j];

                if (dists[u] * p > dists[v]) {
                    dists[v] = dists[u] * p;
                    updated = true;
                }

                if (dists[v] * p > dists[u]) {
                    dists[u] = dists[v] * p;
                    updated = true;
                }
            }

            if (!updated) {
                break;
            }
        }

        return dists[end];
    }
}

class Solution {
    private class Point {
        int curr;
        double prob;

        private Point(int c, double p) {
            curr = c;
            prob = p;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode) {
        final var map = new HashMap<Integer, List<Point>>();
        for (int i = 0; i < succProb.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(new Point(b, succProb[i]));
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(new Point(a, succProb[i]));
        }
        final var maxHeap = new PriorityQueue<Point>((x, y) -> Double.compare(y.prob, x.prob));
        final var dist = new double[n];
        maxHeap.offer(new Point(startNode, 1.0));
        dist[startNode] = 1.0;
        while (!maxHeap.isEmpty()) {
            var curr = maxHeap.poll();
            if (curr.curr == endNode) {
                return curr.prob;
            }
            for (var point : map.getOrDefault(curr.curr, new ArrayList<>())) {
                var nextProb = point.prob * curr.prob;
                if (nextProb > dist[point.curr]) {
                    dist[point.curr] = nextProb;
                    maxHeap.offer(new Point(point.curr, nextProb));
                }
            }
        }
        return 0.0;
    }
}