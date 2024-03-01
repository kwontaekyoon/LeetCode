class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int one = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                one++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < one; i++) {
            sb.append('1');
        }
        for (int i = one; i < len; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}