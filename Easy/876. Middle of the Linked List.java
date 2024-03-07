class Solution {
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }
        return head;
    }
}