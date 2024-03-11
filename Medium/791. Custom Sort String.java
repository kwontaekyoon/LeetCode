class Solution {
    public String customSortString(String order, String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (freqs[c - 'a'] > 0) {
                sb.append(c);
                freqs[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (freqs[i] > 0) {
                sb.append((char) (i + 'a'));
                freqs[i]--;
            }
        }
        return sb.toString();
    }
}