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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode newHead = head;
        int size = 0;
        while (newHead != null) {
            newHead = newHead.next;
            size++;
        }
        int q = size / k, r = size % k;
        for (int i = 0; i < k; i++) {
            ListNode prev = null;
            newHead = head;
            res[i] = newHead;
            if (i < r) { // q + 1
                for (int len = 0; len < q + 1; len++) {
                    prev = head;
                    head = head.next;
                }
            } else { // q
                for (int len = 0; len < q; len++) {
                    prev = head;
                    head = head.next;
                }
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return res;
    }
}