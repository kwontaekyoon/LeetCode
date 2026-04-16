class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            List<Integer> idxs = hashMap.get(nums[q]);
            if (idxs.size() == 1) {
                result.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(idxs, q);
            int left = idxs.get((pos - 1 + idxs.size()) % idxs.size());
            int d1 = Math.abs(q - left);
            int right = idxs.get((pos + 1) % idxs.size());
            int d2 = Math.abs(q - right);;
            result.add(Math.min(Math.min(d1, n - d1), Math.min(d2, n - d2)));
        }
        return result;
    }
}
