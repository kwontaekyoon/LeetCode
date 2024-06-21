class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        final int N = grumpy.length;
        int prefix = 0;
        for (int i = 0; i < minutes; i++) {
            prefix += customers[i];
        }
        for (int i = minutes; i < N; i++) {
            if (grumpy[i] == 0) {
                prefix += customers[i];
            }
        }
        int res = prefix;
        for (int l = 0, r = minutes; r < N; l++, r++) {
            if (grumpy[l] == 1) {
                prefix -= customers[l];
            }
            if (grumpy[r] == 1) {
                prefix += customers[r];
            }
            res = Math.max(res, prefix);
        }
        return res;
    }
}