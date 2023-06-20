class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if ((end - start) * 10000 < max) {
                break;
            } else {
                if (height[start] > height[end]) {
                    max = Math.max(max, (end - start) * height[end]);
                    end--;
                } else {
                    max = Math.max(max, (end - start) * height[start]);
                    start++;
                }
            }
        }
        return max;
    }
}