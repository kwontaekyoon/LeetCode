class Solution {
    private ListNode recursion(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        var next = curr.next;
        curr.next = prev;
        prev = curr;
        return recursion(next, prev);
    }
    public ListNode reverseList(ListNode head) {
        return recursion(head, null);
    }
    public ListNode iteration(ListNode head) {
        ListNode prev = null;
        var curr = head;
        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}