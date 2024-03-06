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

public class TwoPointers {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}