class Solution {
    public int firstUniqChar(String s) {
        int[] freqs = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            freqs[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freqs[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}