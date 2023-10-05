class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int num : nums) {
            if (hm.containsKey(num)) {
                int idx = hm.get(num);
                hm.put(num, idx + 1);
                if (matrix.size() <= idx) {
                    matrix.add(new ArrayList<>());
                }
                matrix.get(idx).add(num);
            } else {
                hm.put(num, 1);
                if (matrix.size() == 0) {
                    matrix.add(new ArrayList<>());
                }
                matrix.get(0).add(num);
            }
        }
        return matrix;
    }
}