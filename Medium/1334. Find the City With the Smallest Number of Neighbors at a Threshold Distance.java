import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class FloydWarchall {
    public int findTheCity(int n, int[][] edges, int threshold) {
        final var dists = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dists[i][j] = Integer.MAX_VALUE;
                    dists[j][i] = Integer.MAX_VALUE;
                }
            }
        }
        for (var e : edges) {
            if (e[2] > threshold) {
                continue;
            }
            dists[e[0]][e[1]] = e[2];
            dists[e[1]][e[0]] = e[2];
        }

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dists[k][i] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (dists[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (dists[i][j] > dists[k][i] + dists[k][j]) {
                        dists[i][j] = dists[k][i] + dists[k][j];
                    }
                }
            }
        }

        int res = -1, cnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currCnt = 0;
            for (int j = 0; j < n; j++) {
                if (dists[i][j] <= threshold) {
                    currCnt++;
                }
            }
            if (currCnt <= cnt) {
                res = i;
                cnt = currCnt;
            }
        }
        return res;
    }
}

class Heap {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final var map = new ArrayList<List<int[]>>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<int[]>());
        }
        for (var e : edges) {
            map.get(e[0]).add(new int[] { e[1], e[2] });
            map.get(e[1]).add(new int[] { e[0], e[2] });
        }
        int res = -1, cnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            final var maxHeap = new PriorityQueue<int[]>((x, y) -> Integer.compare(y[1], x[1]));
            maxHeap.offer(new int[] { i, distanceThreshold });
            final var visited = new boolean[n];
            int cityCnt = 0;
            while (!maxHeap.isEmpty()) {
                var curr = maxHeap.poll();
                int currCity = curr[0], currFuel = curr[1];
                if (visited[currCity]) {
                    continue;
                }
                visited[currCity] = true;
                cityCnt++;
                for (var next : map.get(currCity)) {
                    int nextCity = next[0], cost = next[1];
                    if (!visited[nextCity] && currFuel >= cost) {
                        maxHeap.offer(new int[] { nextCity, currFuel - cost });
                    }
                }
            }
            if (cityCnt <= cnt && i > res) {
                res = i;
                cnt = cityCnt;
            }
        }
        return res;
    }
}