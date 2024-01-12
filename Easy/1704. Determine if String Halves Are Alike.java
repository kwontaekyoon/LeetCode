class Solution {
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int vowels = 0;
        for (int i = 0; i < len / 2; i++) {
            if (isVowel(chars[i])) {
                vowels++;
            }
        }
        for (int i = len / 2; i < len; i++) {
            if (isVowel(chars[i])) {
                vowels--;
            }
        }
        return vowels == 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }
}