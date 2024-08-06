import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        final var pushs = new int[] { 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 };
        final var cnt = new int[26];
        for (var c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            res += pushs[i] * cnt[i];
        }
        return res;
    }
}