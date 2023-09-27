class Solution {
    public String decodeAtIndex(String s, int k) {
        // StringBuilder sb = new StringBuilder();
        // char[] chars = s.toCharArray();
        // for (int i = 0; i < chars.length && sb.length() < k; i++) {
        // if (chars[i] - '2' >= 0 && chars[i] - '9' <= 0) {
        // int iter = chars[i] - '0';
        // if (sb.length() * iter >= k) {
        // k %= sb.length();
        // } else {
        // String tmp = sb.toString();
        // for (int j = 1; j < iter; j++) {
        // sb.append(tmp);
        // }
        // }
        // } else {
        // sb.append(chars[i]);
        // }
        // }
        // return k != 0 ? String.valueOf(sb.charAt(k - 1)) :
        // String.valueOf(sb.charAt(sb.length() - 1));
        int idx = 0;
        long length = 0;
        while (length < k) {
            if (Character.isDigit(s.charAt(idx))) {
                length *= (s.charAt(idx) - '0');
            } else {
                length++;
            }
            idx++;
        }
        for (int i = idx - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                length /= (s.charAt(i) - '0');
                k %= length;
            } else {
                if (k == 0 || k == length) {
                    return Character.toString(s.charAt(i));
                }
                length--;
            }
        }
        return "";
    }
}