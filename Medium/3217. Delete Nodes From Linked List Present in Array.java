class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        final var set = new boolean[100001];
        for (int num : nums) {
            set[num] = true;
        }
        while (set[head.val]) {
            head = head.next;
        }
        final var res = head;
        while (head.next != null) {
            if (set[head.next.val]) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}