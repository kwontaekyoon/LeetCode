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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        prefixSumToNode.put(prefixSum, dummy);
        while (head != null) {
            prefixSum += head.val;
            prefixSumToNode.put(prefixSum, head);
            head = head.next;
        }
        head = dummy;
        prefixSum = 0;
        while (head != null) {
            prefixSum += head.val;
            head.next = prefixSumToNode.get(prefixSum).next;
            head = head.next;
        }
        return dummy.next;
    }
}