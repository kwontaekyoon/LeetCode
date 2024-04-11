class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int remove = nums.length - k;
        var stack = new ArrayDeque<Integer>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peekLast() > num && remove > 0) {
                stack.pollLast();
                remove--;
            }
            stack.offerLast(num);
        }
        var res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }
}