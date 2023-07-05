class Solution {
    public int longestSubarray(int[] nums) {
        int output = Integer.MIN_VALUE;
        List<Integer> sums = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (sum != 0) {
                    sums.add(sum);
                    sum = 0;
                }
                sums.add(0);
            } else {
                sum++;
            }
        }
        if (sum != 0) {
            sums.add(sum);
            sum = 0;
        }
        if (sums.size() == 1) {
            if (sums.get(0) == 0) {
                return 0;
            } else {
                return sums.get(0) - 1;
            }
        }
        output = sums.get(0);
        System.out.println(sums);
        for (int i = 1; i < sums.size() - 1; i++) {
            int tmp = 0;
            tmp += sums.get(i);
            tmp += sums.get(i - 1);
            tmp += sums.get(i + 1);
            output = Math.max(output, tmp);
        }
        return output;
    }
}