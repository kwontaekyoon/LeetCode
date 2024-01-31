class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.replace(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        // Optional<Integer> answer = map.entrySet().stream()
        // .filter(e -> e.getValue() == 1)
        // .map(Map.Entry::getKey)
        // .findFirst();
        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}

// goal -> bit manipulation