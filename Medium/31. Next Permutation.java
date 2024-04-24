class Solution {
    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        final var stack = new ArrayDeque<Integer>();
        for (int i = n - 1; i > -1; i--) {
            int idx = -1;
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                idx = stack.pollLast();
            }
            if (idx != -1) {
                swap(nums, i, idx);
                Arrays.sort(nums, i + 1, n);
                return;
            }
            stack.offerLast(i);
        }
        Arrays.sort(nums);
    }

    private void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}