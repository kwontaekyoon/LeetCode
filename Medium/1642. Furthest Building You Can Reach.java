class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> usedLadders = new PriorityQueue<>();
        int usedBricks = 0;
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) {
                continue;
            }
            if (usedLadders.size() == ladders) {
                if (ladders != 0 && usedLadders.peek() < diff) {
                    usedBricks += usedLadders.poll();
                    usedLadders.offer(diff);
                } else {
                    usedBricks += diff;
                }
            } else {
                usedLadders.offer(diff);
            }
            if (usedLadders.size() == ladders && usedBricks > bricks) {
                return i - 1;
            }
        }
        return heights.length - 1;
    }
}