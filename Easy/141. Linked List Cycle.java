/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> hm = new HashMap<>();
        while (head != null) {
            if (hm.containsKey(head))
                return true;
            else
                hm.put(head, 1);
            head = head.next;
        }
        return false;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // public boolean hasCycle(ListNode head) {
    // Map<ListNode, Integer> hm = new HashMap<>();
    // while(head != null) {
    // if (hm.containsKey(head)) return true;
    // else hm.put(head, 1);
    // head = head.next;
    // }
    // return false;
    // }
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}