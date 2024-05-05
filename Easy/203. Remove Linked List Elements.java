class UsingIterator {
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        var newHead = head;
        while (newHead != null) {
            size++;
            newHead = newHead.next;
        }
        var dummy = new ListNode(0, head);
        head = dummy;
        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        var slow = head;
        var fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}