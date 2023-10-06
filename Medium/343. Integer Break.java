class Solution {
    private int divideAndProduct(int n, int k) {
        int prod = 1;
        int div = n / k, res = n % k;
        for (int i = 1; i <= k; i++) {
            prod *= (res >= i ? div + 1 : div);
        }
        return prod;
    }

    public int integerBreak(int n) {
        int maxProd = Integer.MIN_VALUE;
        for (int k = 2; k <= n; k++) {
            int curProd = divideAndProduct(n, k);
            if (maxProd >= curProd) {
                return maxProd;
            } else {
                maxProd = curProd;
            }
        }
        return maxProd;
    }
}