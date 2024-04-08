class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int t = 0;
        for (int i = 0; i < tickets.length; i++) {
            t += Math.min(tickets[k] - (i <= k ? 0 : 1), tickets[i]);
        }
        return t;
    }
}

class UsingQueue {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        var queue = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            queue.offerLast(new int[] { i, tickets[i] });
        }
        int time = 0;
        while (!queue.isEmpty()) {
            var curr = queue.pollFirst();
            time++;
            if (--curr[1] > 0) {
                queue.offerLast(curr);
            } else {
                if (curr[0] == k) {
                    return time;
                }
            }
        }
        return time;
    }
}