class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (List<Integer> bricks : wall) {
            int cur = 0;
            for (int i = 0; i < bricks.size() - 1; i++) {
                cur += bricks.get(i);
                hm.put(cur, hm.getOrDefault(cur, 0) + 1);
                max = Math.max(max, hm.get(cur));
            }
        }
        return wall.size() - max;
    }
}
