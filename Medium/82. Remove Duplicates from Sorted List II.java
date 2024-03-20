class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        var dummy = new ListNode(0, head);
        var newHead = dummy;
        while (newHead.next != null && newHead.next.next != null) {
            if (newHead.next.val == newHead.next.next.val) {
                var delete = newHead.next.val;
                while (newHead.next != null && newHead.next.val == delete) {
                    newHead.next = newHead.next.next;
                }
            } else {
                newHead = newHead.next;
            }
        }
        return dummy.next;
    }
}