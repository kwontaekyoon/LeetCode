class Solution {
    public int minOperations(String s) {
        final char[] sToChars = s.toCharArray();
        int startWithZero = 0;
        int startWithOne = 0;
        int n = sToChars.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                if (sToChars[i] == '0') {
                    startWithZero += 1;
                } else {
                    startWithOne += 1;
                }
            } else {
                if (sToChars[i] == '0') {
                    startWithOne += 1;
                } else {
                    startWithZero += 1;
                }
            }
        }
        return Math.min(startWithZero, startWithOne);
    }
}