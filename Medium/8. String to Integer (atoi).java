class Solution {
    public int myAtoi(String s) {
        char[] sToChars = s.toCharArray();
        int i = 0;
        int n = s.length();
        int p = 1;
        long r = 0;
        while (i < n && sToChars[i] == ' ') {
            i += 1;
        }
        if (i < n && (sToChars[i] == '-' || sToChars[i] == '+')) {
            p = (sToChars[i] == '-') ? -1 : 1;
            i += 1;
        }
        while (i < n && sToChars[i] >= '0' && sToChars[i] <= '9') {
            r = r * 10 + (sToChars[i] - '0');
            i += 1;
            if (r > Integer.MAX_VALUE) {
                return p == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) r * p;
    }
}