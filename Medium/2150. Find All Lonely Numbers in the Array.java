class Solution {
    public List<Integer> findLonely(int[] nums) {
        // Map<Integer, Integer> numToFreq = new HashMap<>();
        // for (int num : nums) {
        // numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        // }
        // List<Integer> lonelyNums = new ArrayList<>();
        // for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
        // if (entry.getValue() > 1) {
        // continue;
        // }
        // int num = entry.getKey();
        // if (!numToFreq.containsKey(num - 1) && !numToFreq.containsKey(num + 1)) {
        // lonelyNums.add(num);
        // }
        // }
        // return lonelyNums;
        Arrays.sort(nums);
        List<Integer> lonelyNums = new ArrayList<>();
        if (nums.length == 1 || nums[0] + 1 < nums[1]) {
            lonelyNums.add(nums[0]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] - 1 && nums[i + 1] > nums[i] + 1) {
                lonelyNums.add(nums[i]);
            }
        }
        if (nums.length >= 2 && nums[nums.length - 1] > nums[nums.length - 2] + 1) {
            lonelyNums.add(nums[nums.length - 1]);
        }
        return lonelyNums;
    }
}