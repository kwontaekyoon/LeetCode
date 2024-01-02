class Solution {
    // map
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int num : nums) {
            int idx = hm.getOrDefault(num, 0);
            hm.put(num, idx + 1);
            if (matrix.size() < idx + 1) {
                matrix.add(new ArrayList<>());
            }
            matrix.get(idx).add(num);
        }
        return matrix;
    }

    // counter
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        List<List<Integer>> matrix = new ArrayList<>();
        for (int num : nums) {
            int cnt = count[num];
            if (matrix.size() == cnt) {
                matrix.add(new ArrayList<>());
            }
            matrix.get(cnt).add(num);
            count[num]++;
        }
        return matrix;
    }
}