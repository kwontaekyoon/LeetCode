class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final var map = new HashMap<Integer, Integer>();
        final var stack = new ArrayDeque<Integer>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peekLast() < num) {
                map.put(stack.pollLast(), num);
            }
            stack.offerLast(num);
        }

        final int N = nums1.length;
        for (int i = 0; i < N; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}