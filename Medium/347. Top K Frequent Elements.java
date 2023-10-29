class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> freq.get(y) - freq.get(x));
        pq.addAll(freq.keySet());

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll();
        }

        return topK;
    }
}