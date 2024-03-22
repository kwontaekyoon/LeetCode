class UsingList {
    public boolean isPalindrome(ListNode head) {
        var nums = new ArrayList<Integer>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int n = nums.size();
        for (int i = 0; i < n / 2; i++) {
            if (nums.get(i) != nums.get(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
class TwoPointers {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reve = reverse(slow.next);
        slow.next = null;
        while (reve != null) {
            if (reve.val != head.val) {
                return false;
            }
            head = head.next;
            reve = reve.next;
        }
        return true;
    }
}