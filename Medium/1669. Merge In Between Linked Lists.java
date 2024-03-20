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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode one = list1;
        ListNode two = one;
        ListNode res = one;
        for (int i = 0; i <= b; i++) {
            one = one.next;
        }
        for (int i = 1; i < a; i++) {
            two = two.next;
        }
        two.next = list2;
        while (two.next != null) {
            two = two.next;
        }
        two.next = one;
        return res;
    }
}