class Solution {
    private boolean isPalindromic(String word) {
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            if (word.charAt(i) != word.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isPalindromic(words[i])) {
                return words[i];
            }
        }
        return "";
    }
}