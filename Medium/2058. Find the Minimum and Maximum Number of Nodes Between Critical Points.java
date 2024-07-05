class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prev = head.val;
        head = head.next;
        int minDist = Integer.MAX_VALUE;
        int firstIndex = -1, prevIndex = -1;
        for (int i = 0; head.next != null; i++, head = head.next) {
            if ((head.val < prev && head.val < head.next.val) ||
                    (head.val > prev && head.val > head.next.val)) {
                if (prevIndex < 0) {
                    firstIndex = i;
                } else {
                    minDist = Math.min(minDist, i - prevIndex);
                }
                prevIndex = i;
            }
            prev = head.val;
        }
        if (prevIndex != firstIndex && prevIndex > 0) {
            return new int[] { minDist, prevIndex - firstIndex };
        }
        return new int[] { -1, -1 };
    }
}