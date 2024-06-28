class Solution {
    public long maximumImportance(int n, int[][] roads) {
        final var cnt = new int[n + 1];
        for (var road : roads) {
            cnt[road[0]]++;
            cnt[road[1]]++;
        }
        Arrays.sort(cnt);
        var res = 0L;
        for (int i = 1; i <= n; i++) {
            res += (long) i * cnt[i];
        }
        return res;
    }
}