class Solution {
    public char findTheDifference(String s, String t) {
        // int[] cnts = new int[26];
        // for (char c : s.toCharArray()) {
        // cnts[c - 'a']++;
        // }
        // for (char c : t.toCharArray()) {
        // cnts[c - 'a']--;
        // if (cnts[c - 'a'] == -1) {
        // return c;
        // }
        // }
        // return 'x';
        // char is int
        int cnt = 0;
        for (char c : t.toCharArray()) {
            cnt += c;
        }
        for (char c : s.toCharArray()) {
            cnt -= c;
        }
        return (char) cnt;
    }
}