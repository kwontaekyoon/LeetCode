class Solution {
    private final static int MOD = 1000000007;

    private int rev(int n) {
        // reversed number
        int rev = 0;
        // remainder
        int rem;

        while (n > 0) {
            rem = n % 10;
            rev = (rev * 10) + rem;
            n = n / 10;
        }

        return rev;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        long cnt = 0;

        for (int num : nums) {
            int res = num - rev(num);
            int resCnt = hm.getOrDefault(res, 0);
            cnt = (cnt + resCnt) % MOD;
            hm.put(res, resCnt + 1);
        }

        return (int) cnt;
    }
}