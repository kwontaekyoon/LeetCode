class Solution {
    public String largestOddNumber(String num) {
        for (int size = num.length() - 1; size > -1; size--) {
            if ((num.charAt(size) - '0') % 2 == 1) {
                return num.substring(0, size + 1);
            }
        }
        return "";
    }
}