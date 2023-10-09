class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> hs = new HashSet<>();
        hs.add(0);
        for (int num1 : nums) {
            for (int num2 : new ArrayList<>(hs)) {
                if (num1 + num2 == target) {
                    return true;
                } else {
                    hs.add(num1 + num2);
                }
            }
        }
        return false;
    }
}