class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        final int n = queries.length, m = arr.length;
        final var prefix = new int[m + 1];
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        final var res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
        }
        return res;
    }
}