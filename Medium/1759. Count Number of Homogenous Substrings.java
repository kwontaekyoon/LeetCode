class Solution {
    private static final int MOD = (int) 1e9 + 7;
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        long cnt = 0L;
        int len = s.length();
        for (int l = 0, r = 0; r < len; r++) {
            if (chars[l] == chars[r]) {
                cnt += (r - l + 1);
            } else {
                cnt += 1;
                l = r;
            }
        }
        return (int) (cnt % MOD);
    }
}

/**
1 -> 1
1 2 -> 3
1 2 3 -> 6
1 2 3 4 -> 10
1 2 3 4 5 -> 15
(n + 1) * n / 2
 */
