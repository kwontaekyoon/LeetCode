class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prefixSum = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            prefixSum += (i + 1) * satisfaction[i];
        }
        int maxSatisfaction = prefixSum;
        for (int i = satisfaction.length - 2; i > -1; i--) {
            satisfaction[i] += satisfaction[i + 1];
        }
        for (int i = 0; i < satisfaction.length; i++) {
            prefixSum -= satisfaction[i];
            maxSatisfaction = Math.max(prefixSum, maxSatisfaction);
        }
        return maxSatisfaction;
    }
}