class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            k ^= num;
        }
        int ops = 0;
        // for (var c : Integer.toBinaryString(diff).toCharArray()) {
        //     if (c == '1') {
        //         ops++;
        //     }
        // }
        while (k > 0) {
            if (k % 2 == 1) {
                ops++;
            }
            k /= 2;
        }
        return ops;
    }
}