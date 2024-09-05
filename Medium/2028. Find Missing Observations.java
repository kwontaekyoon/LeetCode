class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        final int m = rolls.length;
        int sumOfRolls = 0;
        for (int roll : rolls) {
            sumOfRolls += roll;
        }
        int total = (n + m) * mean;
        int miss = total - sumOfRolls;
        if (miss > 6 * n || miss < n) {
            return new int[] {};
        }
        int q = miss / n, r = miss % n;
        final var res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = q + (i < r ? 1 : 0);
        }
        return res;
    }
}