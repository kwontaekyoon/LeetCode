class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftBounds = new int[n];
        int[] rightBounds = new int[n];
        leftBounds[0] = -1;
        rightBounds[n - 1] = n;

        // get left bounds
        for (int i = 1; i < n; i++) {
            int b = i - 1;
            while (b > -1 && heights[b] >= heights[i]) {
                b = leftBounds[b];
            }
            leftBounds[i] = b;
        }

        // get right bounds
        for (int i = n - 2; i > -1; i--) {
            int b = i + 1;
            while (b < n && heights[b] >= heights[i]) {
                b = rightBounds[b];
            }
            rightBounds[i] = b;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (rightBounds[i] - leftBounds[i] - 1));
        }

        return max;
    }
}