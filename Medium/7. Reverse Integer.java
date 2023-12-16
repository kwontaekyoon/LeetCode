class Solution {
    private final static int MAX = Integer.MAX_VALUE;
    private final static int MIN = Integer.MIN_VALUE;

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            if (r > MAX / 10 || r < MIN / 10) {
                return 0;
            }
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}