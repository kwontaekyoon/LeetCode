class Solution {
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