class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        List<Map<Integer, Integer>> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
        }
        int numOfSlices = 0;
        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> cur = dp.get(i);
            for (int j = i - 1; j > -1; j--) {
                long diff = (long) nums[i] - nums[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                Map<Integer, Integer> pre = dp.get(j);
                int preCount = pre.getOrDefault((int) diff, 0);
                int curCount = cur.getOrDefault((int) diff, 0);
                numOfSlices += preCount;
                cur.put((int) diff, preCount + curCount + 1);
            }
        }
        return numOfSlices;
    }
}
