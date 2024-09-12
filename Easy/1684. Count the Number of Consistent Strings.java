class Solution {
    public int countConsistentStrings(String a, String[] words) {
        final var allowed = new boolean[26];
        for (var c : a.toCharArray()) {
            allowed[c - 'a'] = true;
        }
        int cnt = 0;
        for (var word : words) {
            if (check(allowed, word)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(boolean[] allowed, String word) {
        for (var c : word.toCharArray()) {
            if (!allowed[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}