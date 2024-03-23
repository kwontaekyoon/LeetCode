class UsingQueue {
    public void reorderList(ListNode head) {
        var nodes = new ArrayDeque<ListNode>();
        while (head != null) {
            nodes.offer(head);
            head = head.next;
        }
        var dummy = nodes.pollFirst();
        while (nodes.size() >= 2) {
            dummy.next = nodes.pollLast();
            dummy = dummy.next;
            dummy.next = nodes.pollFirst();
            dummy = dummy.next;
        }
        if (!nodes.isEmpty()) {
            dummy.next = nodes.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
    }
}

class TwoPointers {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)  {
            return;
        }
        ListNode tmp = head, half = head, prev = null;
        while (tmp.next != null && tmp.next.next != null) {
            tmp = tmp.next.next;
            half = half.next;
        }

        if (tmp.next != null) {
            half = half.next;
        }

        while (half != null) {
            tmp = half.next;
            half.next = prev;
            prev = half;
            half = tmp;
        }
        half = prev;

        while (head != null && half != null) {
            tmp = head.next;
            prev = half.next;
            head.next = half;
            half.next = tmp;
            head = tmp;
            half = prev;
        }

        if (head != null && head.next != null) {
            head.next.next = null;
        }
    }
}