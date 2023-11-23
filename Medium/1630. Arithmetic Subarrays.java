class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        // (nlogn + n) * m
        List<Boolean> res = new ArrayList<>();
        out: for (int i = 0; i < l.length; i++) {
            int[] tmp = new int[r[i] - l[i] + 1];
            for (int j = l[i], k = 0; j <= r[i]; j++, k++) {
                tmp[k] = nums[j];
            }
            Arrays.sort(tmp);
            for (int j = 2, d = tmp[1] - tmp[0]; j < tmp.length; j++) {
                if (tmp[j] - tmp[j - 1] != d) {
                    res.add(false);
                    continue out;
                }
            }
            res.add(true);
        }
        return res;
    }
}