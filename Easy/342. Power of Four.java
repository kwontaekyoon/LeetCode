class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        // if log4 is int return true
        return Math.log(n) / Math.log(4) % 1 == 0;
    }
}