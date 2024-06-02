class Solution {
    private final static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        final var chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !VOWELS.contains(chars[l])) {
                l++;
            }
            while (l < r && !VOWELS.contains(chars[r])) {
                r--;
            }
            var tmp = chars[r];
            chars[r] = chars[l];
            chars[l] = tmp;
            l++;
            r--;
        }
        return new String(chars);
    }
}