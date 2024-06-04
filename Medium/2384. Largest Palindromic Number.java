class Solution {
    public String largestPalindromic(String num) {
        final var map = new int[10];
        for (var c : num.toCharArray()) {
            map[c - '0']++;
        }
        final var res = new StringBuilder();
        int odd = -1;
        for (int i = 9; i >= 0; i--) {
            while (map[i] > 1 && (!res.isEmpty() || i > 0)) {
                res.append(i);
                map[i] -= 2;
            }
        }
        final var rev = new StringBuilder(res).reverse();
        for (int i = 9; i >= 0; i--) {
            if (map[i] > 0) {
                res.append(i);
                break;
            }
        }
        return res.append(rev).toString();
    }
}