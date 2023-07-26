class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 100000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isOki(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right == 100000000 ? -1 : right;
    }

    private boolean isOki(int[] dist, double hour, int speed) {
        int time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        return time + (double) dist[dist.length - 1] / speed <= hour;
    }
}