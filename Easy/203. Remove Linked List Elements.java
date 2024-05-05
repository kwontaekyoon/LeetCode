class Solution {
    public ListNode removeElements(ListNode head, int val) {
        var dummy = new ListNode(-1, head);
        var newHead = dummy;
        while (head != null) {
            if (head.val != val) {
                newHead.next = head;
                newHead = newHead.next;
            }
            head = head.next;
            newHead.next = null;
        }
        return dummy.next;
    }
}