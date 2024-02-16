class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numToFreq.put(arr[i], numToFreq.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> freqs = new ArrayList<>(numToFreq.values());
        Collections.sort(freqs);
        n = freqs.size();
        for (int i = 0; i < n; i++) {
            k -= freqs.get(i);
            if (k < 0) {
                return n - i;
            }
        }
        return 0;
    }
}