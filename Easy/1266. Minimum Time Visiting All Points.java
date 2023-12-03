class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int[] A = points[i - 1], B = points[i];
            int H = Math.abs(A[0] - B[0]);
            int V = Math.abs(A[1] - B[1]);
            int D = Math.min(H, V);
            ans += (H + V - D);
        }
        return ans;
    }
}