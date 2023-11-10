/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        if (len == 1) {
            return null;
        }
        tmp = head;
        len = len - n + 1;
        
        if (len == 1) {
            return head.next;
        }
        while (len - 2 > 0) {
            tmp = tmp.next;
            len--;
        }
        if (n == 1) {
            tmp.next = null;
        } else {
            tmp.next = tmp.next.next;
        }
        return head;
    }
}
