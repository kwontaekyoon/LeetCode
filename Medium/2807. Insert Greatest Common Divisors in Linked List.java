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
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode now = head;
        while (now.next != null) {
            int GCD;
            if (now.val % now.next.val == 0 || now.next.val % now.val == 0) {
                GCD = Math.min(now.val, now.next.val);
            } else {
                GCD = gcd(now.val, now.next.val);
            }
            now.next = new ListNode(GCD, now.next);
            now = now.next.next;
        }
        return head;
    }
}