class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList<>();
        Arrays.sort(nums);
        int cnt = 0, last = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == last) {
                cnt++;
            } else {
                if (cnt > (nums.length / 3)) {
                    majority.add(last);
                }
                last = num;
                cnt = 1;
            }
        }
        if (cnt > (nums.length / 3)) {
            majority.add(last);
        }
        return majority;
    }
}