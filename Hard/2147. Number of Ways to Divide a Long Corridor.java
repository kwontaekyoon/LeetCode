class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {
        long ans = 1;
        int cntS = 0, cntP = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                if (cntS > 0 && cntS % 2 == 0) {
                    ans = (ans * (cntP + 1)) % MOD;
                    cntP = 0;
                }
                cntS++;
            } else {
                if (cntS > 0 && cntS % 2 == 0) {
                    cntP++;
                }
            }
        }
        return (cntS > 0 && cntS % 2 == 0) ? (int) ans : 0;
    }
}