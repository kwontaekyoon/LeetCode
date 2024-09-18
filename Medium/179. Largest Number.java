import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        final int n = nums.length;
        final var array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (x, y) -> (y + x).compareTo(x + y));
        if (array[0].equals("0")) {
            return "0";
        }
        final var res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(array[i]);
        }
        return res.toString();
    }
}