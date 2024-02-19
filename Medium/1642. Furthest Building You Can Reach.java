class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> usedLadders = new PriorityQueue<>();
        int usedBricks = 0, n = heights.length;
        for (int i = 1; i < n; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) {
                continue;
            }
            if (usedLadders.size() < ladders) {
                usedLadders.offer(diff);
            } else {
                if (ladders != 0 && usedLadders.peek() < diff) {
                    usedBricks += usedLadders.poll();
                    usedLadders.offer(diff);
                } else {
                    usedBricks += diff;
                }
                if (usedBricks > bricks) {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }
}