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
                reverse(nums, i + 1, n - 1);
                return;
            }
            stack.offerLast(i);
        }
        reverse(nums, 0, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}