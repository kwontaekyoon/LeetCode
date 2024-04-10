class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        var res = new int[n];
        for (int i = 0; i < n; i++) {
            res[queue.poll()] = deck[i];
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return res;
    }
}