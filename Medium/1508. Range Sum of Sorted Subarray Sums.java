class Solution {
    final static int MOD = (int) 1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        final var cnt = new int[100001];
        for (int r = 0; r < n; r++) {
            int sum = 0;
            for (int l = r; l >= 0; l--) {
                sum += nums[l];
                cnt[sum]++;
            }
        }
        var res = 0L;
        for (int i = 1, c = 0; i < 100001; i++) {
            while (cnt[i] > 0) {
                c++;
                cnt[i]--;
                if (c >= left && c <= right) {
                    res += i;
                    res %= MOD;
                }
            }
            if (c > right) {
                break;
            }
        }
        return (int) res;
    }
}