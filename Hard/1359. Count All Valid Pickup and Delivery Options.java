class Solution {
    private int MOD = 1000000007;

    public int countOrders(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * (i * 2 - 1) * i) % MOD;
        }
        return (int) res;
    }
}