class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        final var res = new ListNode[k];
        var dummy = head;
        int size = 0;
        while (dummy != null) {
            size++;
            dummy = dummy.next;
        }
        int q = size / k, r = size % k;
        for (int i = 0; i < r; i++) {
            res[i] = head;
            for (int j = 0; j < q; j++) {
                head = head.next;
            }
            dummy = head.next;
            head.next = null;
            head = dummy;
        }
        if (q == 0) {
            return res;
        }
        for (int i = r; i < k; i++) {
            res[i] = head;
            for (int j = 1; j < q; j++) {
                head = head.next;
            }
            dummy = head.next;
            head.next = null;
            head = dummy;
        }
        return res;
    }
}

class Solution2 {
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