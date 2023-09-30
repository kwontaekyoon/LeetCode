class Solution {
    public boolean find132pattern(int[] nums) {
        // brute force -> X
        // for (int one = 0; one < nums.length - 2; one++) {
        // for (int two = one + 1; two < nums.length - 1; two++) {
        // if (nums[two] <= nums[one]) {
        // continue;
        // }
        // for (int tre = two + 1; tre < nums.length; tre++) {
        // if (nums[tre] > nums[one] && nums[tre] < nums[two]) {
        // return true;
        // }
        // }
        // }
        // }
        // return false;
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}