class ReverseListNode {
    public ListNode doubleIt(ListNode head) {
        var prev = new ListNode();
        var curr = reverse(null, head, null);
        var temp = curr;
        int carry = 0;
        while (curr != null) {
            int doubled = curr.val * 2 + carry;
            carry = doubled / 10;
            curr.val = doubled % 10;
            prev = curr;
            curr = curr.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return reverse(null, temp, null);
    }

    private ListNode reverse(ListNode prev, ListNode curr, ListNode next) {
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class Solution {
    public ListNode doubleIt(ListNode curr) {
        var prev = new ListNode(0, curr);
        var temp = prev;
        while (curr != null) {
            int doubled = curr.val * 2;
            prev.val += doubled / 10;
            curr.val = doubled % 10;
            prev = curr;
            curr = curr.next;
        }
        return temp.val > 0 ? temp : temp.next;
    }
}