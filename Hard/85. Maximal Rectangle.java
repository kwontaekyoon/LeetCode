class Solution {
    public int maximalRectangle(char[][] matrix) {
        final int R = matrix.length, C = matrix[0].length;
        final var heights = new int[C + 1];
        int maxArea = 0;
        for (var row : matrix) {
            for (int c = 0; c < C; c++) {
                heights[c] = (row[c] == '1') ? heights[c] + 1 : 0;
            }

            var stack = new ArrayDeque<Integer>();
            for (int c = 0; c <= C; c++) {
                while (!stack.isEmpty() && heights[c] < heights[stack.peekLast()]) {
                    int h = heights[stack.pollLast()];
                    int w = stack.isEmpty() ? c : c - stack.peekLast() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.offerLast(c);
            }
        }
        return maxArea;
    }
}