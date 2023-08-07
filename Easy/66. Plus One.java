class Solution {
    private int[] helper(int[] digits) {
        int[] output = new int[digits.length + 1];
        output[0] = 1;
        for (int i = 1; i < output.length; i++) {
            output[i] = digits[i - 1];
        }
        return output;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] > 9) {
                digits[i] -= 10;
            } else {
                break;
            }
        }
        return digits[0] != 0 ? digits : helper(digits);
    }
}