class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> countNums = new HashMap<>();
        for (int num : nums) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }
        int minOperations = 0;
        for (int count : countNums.values()) {
            if (count == 1) {
                return -1;
            }
            minOperations += Math.ceil((double) count / 3);
        }
        return minOperations;
    }

    public int minOperations(int[] nums) {
        Map<Integer, Integer> countNums = new HashMap<>();
        for (int num : nums) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }
        int minOperations = 0;
        out: for (int count : countNums.values()) {
            for (int two = 0; two <= count / 2; two++) {
                int res = count - two * 2;
                if (res % 3 == 0) {
                    minOperations += (two + res / 3);
                    continue out;
                }
            }
            return -1;
        }
        return minOperations;
    }
}