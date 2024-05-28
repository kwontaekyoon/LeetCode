class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        final int N = s.length();
        final var cost = new int[N];
        final var S = s.toCharArray();
        final var T = t.toCharArray();
        for (int i = 0; i < N; i++) {
            cost[i] = Math.abs(S[i] - T[i]);
        }
        int maxLen = 0, currCost = 0, start = 0, end = 0;
        while (end < N) {
            currCost += cost[end];
            while (currCost > maxCost) {
                currCost -= cost[start++];
            }
            maxLen = Math.max(maxLen, end++ - start + 1);
        }
        return maxLen;
    }
}