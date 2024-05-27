class Solution {
    public int specialArray(int[] nums) {
        final var N = nums.length;
        final var map = new int[N + 1];
        for (var num : nums) {
            if (num > N) {
                map[N]++;
            } else {
                map[num]++;
            }
        }
        for (int i = N, s = 0; i >= 0; i--) {
            s += map[i];
            if (i < s) {
                return -1;
            }
            if (i == s) {
                return i;
            }
        }
        return -1;
    }
}