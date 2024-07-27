class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final var dists = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < cost.length; i++) {
            dists[original[i] - 'a'][changed[i] - 'a'] = Math.min(dists[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dists[i][k] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    if (dists[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
                }
            }
        }
        var res = 0L;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (dists[s][t] == Integer.MAX_VALUE) {
                return -1;
            }
            res += (long) dists[s][t];
        }
        return res;
    }
}