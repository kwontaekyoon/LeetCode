class Solution {
    private char[] chars;
    private int maxLen = 0, startIdx = 0;

    private void expandAndFind(int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            maxLen = right - left - 1;
            startIdx = left + 1;
        }
    }

    public String longestPalindrome(String s) {
        chars = s.toCharArray();
        if (s.length() < 2) {
            return s;
        } else {
            for (int i = 0; i < chars.length; i++) {
                expandAndFind(i, i);
                expandAndFind(i, i + 1);
            }
            return s.substring(startIdx, startIdx + maxLen);
        }
    }
}