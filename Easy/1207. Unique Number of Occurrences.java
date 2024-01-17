class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : arr) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        Set<Integer> freqs = new HashSet<>();
        for (int freq : numToFreq.values()) {
            if (!freqs.add(freq)) {
                return false;
            }
        }
        return true;
    }
}