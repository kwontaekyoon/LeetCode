class Solution {
    public int majorityElement(int[] nums) {
        int limit = nums.length / 2;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            if (hm.get(num) > limit)
                return num;
        }
        return -1;
    }
}

class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[0] == nums[nums.length / 2] ? nums[0] : nums[nums.length / 2];
    }
}