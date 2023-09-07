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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> al = new ArrayList<>();
        while (head != null) {
            al.add(new ListNode(head.val));
            head = head.next;
        }
        ListNode res = new ListNode();
        ListNode pt = res;
        for (int i = 0; i < al.size(); i++) {
            if (i >= left - 1 && i <= right - 1) {
                pt.next = al.get((right - 1) - (i - left + 1));
            } else {
                pt.next = al.get(i);
            }
            pt = pt.next;
        }
        return res.next;
    }
}