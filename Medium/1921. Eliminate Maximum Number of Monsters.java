class Sorting {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        var time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            if (time[i] > i) {
                continue;
            }
            return i;
        }
        return n;
    }
}

class Math {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        var time = new int[n];
        for (int i = 0; i < n; i++) {
            int t = dist[i] / speed[i] + (dist[i] % speed[i] == 0 ? 0 : 1);
            if (t < n) {
                time[t]++;
            }
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res += time[i];
            if (res > i) {
                return i;
            }
        }
        return n;
    }
}