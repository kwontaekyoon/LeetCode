class Solution {
    public double myPow(double x, int n) {
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1.00000;
        } else if (n > 0) {
            if (n == 1) {
                return x;
            } else if (n % 2 == 0) {
                return Math.pow(helper(x, n / 2), 2);
            } else {
                return x * Math.pow(helper(x, n / 2), 2);
            }
        } else {
            if (n == -2147483648) {
                return Math.pow(helper(x, n / 2), 2);
            } else {
                return 1.00000 / helper(x, -n);
            }
        }
    }
}