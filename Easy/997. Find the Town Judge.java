class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inbound = new int[n + 1];
        int[] outbound = new int[n + 1];
        for (int[] vote : trust) {
            outbound[vote[0]]++;
            inbound[vote[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (outbound[i] == 0 && inbound[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}