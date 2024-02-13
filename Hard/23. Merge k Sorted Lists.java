class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int end = lists.length - 1;
        while (end > 0) {
            int start = 0;
            while (start < end) {
                lists[start] = merge(lists[start], lists[end]);
                start++;
                end--;
            }
        }
        return lists[0];
    }
    private ListNode merge(ListNode first, ListNode second) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (first != null && second != null) {
            if (first.val < second.val) {
                tmp.next = first;
                first = first.next;
            } else {
                tmp.next = second;
                second = second.next;
            }
            tmp = tmp.next;
        }
        tmp.next = first != null ? first : second;
        return res.next;
    }
}