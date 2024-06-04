class Solution {
    public int longestPalindrome(String s) {
        final var map = new int[58];
        for (var c : s.toCharArray()) {
            map[c - 'A']++;
        }
        int res = 0, odd = 0;
        for (int cnt : map) {
            if (cnt % 2 > 0) {
                res += cnt - 1;
                odd = 1;
            } else {
                res += cnt;
            }
        }
        return res + odd;
    }
}