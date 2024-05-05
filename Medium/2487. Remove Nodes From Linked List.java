class UsingStack {
    public ListNode removeNodes(ListNode head) {
        final var dummy = new ListNode(Integer.MAX_VALUE, head);
        final var stack = new ArrayDeque<ListNode>();
        stack.offerLast(dummy);
        while (head != null) {
            while (!stack.isEmpty() && stack.peekLast().val < head.val) {
                stack.pollLast();
            }
            stack.peekLast().next = head;
            stack.offerLast(head);
            head = head.next;
        }
        return stack.pollFirst().next;
    }
}

class Recursion {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }
}

class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode link = null;
        while (curr != null) {
            link = curr.next;
            curr.next = prev;
            prev = curr;
            curr = link;
        }

        curr = prev;
        while (prev != null && prev.next != null) {
            if (prev.val > prev.next.val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        prev = null;
        link = null;
        while (curr != null) {
            link = curr.next;
            curr.next = prev;
            prev = curr;
            curr = link;
        }

        return prev;
    }
}