class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        final var chars = s.toCharArray();
        final var sb = new StringBuilder(s.substring(0, 2));
        for (var i = 2; i < s.length(); i++) {
            var size = sb.length();
            if (sb.charAt(size - 1) != chars[i] || sb.charAt(size - 2) != chars[i]) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}