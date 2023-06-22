/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode now = answer;
        while (!(l1 == null && l2 == null)) {
            int val1, val2;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else {
                val1 = 0;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            } else {
                val2 = 0;
            }
            int sum = val1 + val2;
            if (now.val + sum >= 10) {
                now.val = now.val + sum - 10;
                now.next = new ListNode(1);
            } else {
                now.val = now.val + sum;
                if (l1 != null || l2 != null) {
                    now.next = new ListNode();
                }
            }
            now = now.next;
        }
        return answer;
    }
}