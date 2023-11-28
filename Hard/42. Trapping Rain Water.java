class Solution {
    public int trap(int[] height) {
        int ans = 0, len = height.length;
        // from left
        int highestFromLeft = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (highestFromLeft < height[i]) {
                ans -= i * (height[i] - highestFromLeft);
                highestFromLeft = height[i];
            }
            sum += height[i];
        }
        // from right
        int highestFromRight = 0;
        for (int i = len - 1; i > -1; i--) {
            if (highestFromRight < height[i]) {
                ans -= (len - 1 - i) * (height[i] - highestFromRight);
                highestFromRight = height[i];
            }
            if (highestFromRight == highestFromLeft) {
                break;
            }
        }
        return len * highestFromLeft + ans - sum;
    }
}