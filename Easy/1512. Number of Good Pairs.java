class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int numOfPairs = 0;
        for (int num : hm.values()) {
            numOfPairs += (num * (num - 1) / 2);
        }
        return numOfPairs;
    }
}