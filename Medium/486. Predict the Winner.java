class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return Simulator(nums, 0, 0, nums.length - 1, true) >= 0;
    }

    private int Simulator(int[] nums, int score, int left, int right, boolean isMyTurn) {
        if (left == right) {
            return isMyTurn ? score + nums[left] : score - nums[left];
        } else {
            if (isMyTurn) {
                int pickLeft = Simulator(nums, score + nums[left], left + 1, right, false);
                int pickRight = Simulator(nums, score + nums[right], left, right - 1, false);
                return Math.max(pickLeft, pickRight);
            } else {
                int pickLeft = Simulator(nums, score - nums[left], left + 1, right, true);
                int pickRight = Simulator(nums, score - nums[right], left, right - 1, true);
                return Math.min(pickLeft, pickRight);
            }
        }
    }
}