import java.util.PriorityQueue;

class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int K;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        for (int num : nums) {
            minHeap.offer(num);
        }
        K = k;
    }

    public int add(int val) {
        minHeap.offer(val);
        while (minHeap.size() > K) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}