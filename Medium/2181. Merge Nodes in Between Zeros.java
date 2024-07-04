class Solution {
    public ListNode mergeNodes(ListNode head) {
        var prev = head;
        var curr = head.next;
        while (curr != null) {
            while (curr.val > 0) {
                prev.val += curr.val;
                curr = curr.next;
            }
            prev.next = curr.next;
            prev = prev.next;
            if (curr.next == null) {
                break;
            }
            curr = curr.next.next;
        }
        return head;
    }
}