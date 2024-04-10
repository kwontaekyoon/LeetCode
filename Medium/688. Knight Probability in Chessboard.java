class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        var dir = new int[] { -2, 1, 2, -1, 2, 1, -2, -1, -2 };
        var map = new double[n][n];
        map[r][c] = 1;
        for (int i = 0; i < k; i++) {
            var tmp = new double[n][n];
            for (int cr = 0; cr < n; cr++) {
                for (int cc = 0; cc < n; cc++) {
                    if (map[cr][cc] == 0) {
                        continue;
                    }
                    for (int d = 0; d < 8; d++) {
                        int nr = cr + dir[d], nc = cc + dir[d + 1];
                        if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                            continue;
                        }
                        tmp[nr][nc] += map[cr][cc] / 8;
                    }
                }
            }
            map = tmp;
        }
        var res = 0.0;
        for (var row : map) {
            for (var prob : row) {
                res += prob;
            }
        }
        return res;
    }
}

class UsingMap {
    public double knightProbability(int n, int k, int r, int c) {
        var map = new HashMap<List<Integer>, Double>();
        var dir = new int[] { -2, 1, 2, -1, 2, 1, -2, -1, -2 };
        map.put(List.of(r, c), 1.0);
        for (int i = 0; i < k; i++) {
            var tmp = new HashMap<List<Integer>, Double>();
            for (var entry : map.entrySet()) {
                var ck = entry.getKey();
                var cp = entry.getValue();
                for (int d = 0; d < 8; d++) {
                    var nk = List.of(ck.get(0) + dir[d], ck.get(1) + dir[d + 1]);
                    if (nk.get(0) < 0 || nk.get(1) < 0 || nk.get(0) >= n || nk.get(1) >= n) {
                        continue;
                    }
                    tmp.put(nk, tmp.getOrDefault(nk, 0.0) + cp / 8);
                }
                map = tmp;
            }
        }
        var ans = 0.0;
        for (var prob : map.values()) {
            ans += prob;
        }
        return ans;
    }
}