class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xPoints = new int[points.length];
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] = points[i][0];
        }
        Arrays.sort(xPoints);
        int maxWidth = 0;
        for (int i = 1; i < xPoints.length; i++) {
            maxWidth = Math.max(xPoints[i] - xPoints[i - 1], maxWidth);
        }
        return maxWidth;
    }
}