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
        Stack<Integer> l1ToStack = new Stack<>();
        Stack<Integer> l2ToStack = new Stack<>();
        while (l1 != null) {
            l1ToStack.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2ToStack.push(l2.val);
            l2 = l2.next;
        }
        ListNode answer = new ListNode();
        while (!l1ToStack.isEmpty() || !l2ToStack.isEmpty()) {
            if (!l1ToStack.isEmpty()) {
                answer.val += l1ToStack.pop();
            }
            if (!l2ToStack.isEmpty()) {
                answer.val += l2ToStack.pop();
            }
            if (answer.val < 10) {
                ListNode tmp = new ListNode();
                tmp.next = answer;
                answer = tmp;
            } else {
                ListNode tmp = new ListNode(answer.val / 10);
                answer.val = answer.val % 10;
                tmp.next = answer;
                answer = tmp;
            }
        }
        return answer.val == 0 ? answer.next : answer;
    }
}