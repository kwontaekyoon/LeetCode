class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        final var weights = new int[26];
        for (int i = 0; i < 26; i++) {
            weights[i] = i + 1;
        }
        final var jokers = chars.toCharArray();
        final var N = vals.length;
        for (int i = 0; i < N; i++) {
            weights[jokers[i] - 'a'] = vals[i];
        }
        int max = 0;
        int currMax = 0;
        for (var curr : s.toCharArray()) {
            int currWeight = weights[curr - 'a'];
            currMax = Math.max(currMax, 0) + currWeight;
            max = Math.max(max, currMax);
        }
        return max;
    }
}