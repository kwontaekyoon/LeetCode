class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int N = nums.length;
        final var res = new int[N];
        Arrays.fill(res, -1);
        final var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                res[stack.pollLast()] = nums[i];
            }
            stack.offerLast(i);
        }
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                res[stack.pollLast()] = nums[i];
            }
            stack.offerLast(i);
        }
        return res;
    }
}