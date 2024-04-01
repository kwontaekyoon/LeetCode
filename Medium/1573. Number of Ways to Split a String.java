class Solution {
    private final static int MOD = (int) 1e9 + 7;

    public int numWays(String s) {
        int n = s.length();
        var ones = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        int m = ones.size();
        if (m % 3 != 0) {
            return 0;
        }
        if (m == 0) {
            return (int) ((n - 1L) * (n - 2L) / 2 % MOD);
        }

        m /= 3;
        long first = ones.get(m) - ones.get(m - 1);
        long second = ones.get(2 * m) - ones.get(2 * m - 1);
        return (int) (first * second % MOD);
    }
}