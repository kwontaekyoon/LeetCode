class Solution {
    public int pivotInteger(int n) {
        int preSum = 0;
        for (int i = 1; i <= n; i++) {
            preSum += i;
        }
        int postSum = 0;
        for (int i = 1; i <= n; i++) {
            postSum += i;
            preSum -= i - 1;
            if (preSum == postSum) {
                return i;
            }
        }
        return -1;
    }
}