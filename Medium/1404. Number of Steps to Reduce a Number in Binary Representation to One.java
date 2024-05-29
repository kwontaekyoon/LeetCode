class Solution {
    public int numSteps(String s) {
        final var chars = s.toCharArray();
        final var N = chars.length;
        int count = 0, carry = 0;
        for (int i = N - 1; i > 0; i--) {
            if ((carry + chars[i] - '0') % 2 > 0) {
                carry = 1;
                count += 2;
            } else {
                count++;
            }
        }
        if (carry == 1) {
            count++;
        }
        return count;
    }
}