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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode secondHead = new ListNode(-1);
        ListNode secondPt = secondHead;
        ListNode firstHead = new ListNode(-1);
        ListNode firstPt = firstHead;
        while (head != null) {
            if (head.val >= x) {
                secondPt.next = new ListNode(head.val);
                secondPt = secondPt.next;
            } else {
                firstPt.next = new ListNode(head.val);
                firstPt = firstPt.next;
            }
            head = head.next;
        }
        firstHead = firstHead.next;
        if (firstHead == null)
            return secondHead.next;
        secondHead = secondHead.next;
        ListNode answer = firstHead;
        ListNode answerPt = firstHead;
        while (answerPt.next != null) {
            answerPt = answerPt.next;
        }
        answerPt.next = secondHead;
        return answer;
    }
}