class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[0], y[0]));
        int end = points[0][1];
        int cnt = 1;
        for (int[] point : points) {
            if (point[0] > end) {
                cnt++;
                end = point[1];
            } else {
                end = Math.min(end, point[1]);
            }
        }
        return cnt;
    }
}