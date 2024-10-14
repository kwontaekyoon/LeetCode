import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        final var maxHeap = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        for (int num : nums) {
            maxHeap.offer(num);
        }
        var res = 0L;
        while (k > 0) {
            var curr = maxHeap.poll();
            while (k > 0 && (maxHeap.isEmpty() || curr >= maxHeap.peek())) {
                res += curr;
                curr = (curr + 2) / 3;
                k--;
            }
            maxHeap.offer(curr);
        }
        return res;
    }
}