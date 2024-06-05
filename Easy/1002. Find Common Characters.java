class Solution {
    public List<String> commonChars(String[] words) {
        final var N = words.length;
        final var cnt = new int[N][26];
        for (int i = 0; i < N; i++) {
            for (var c : words[i].toCharArray()) {
                cnt[i][c - 'a']++;
            }
        }
        final var res = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            int max = N;
            for (int j = 0; j < N; j++) {
                max = Math.min(max, cnt[j][i]);
            }
            var s = String.valueOf((char) ('a' + i));
            for (int k = 0; k < max; k++) {
                res.add(s);
            }
        }
        return res;
    }
}