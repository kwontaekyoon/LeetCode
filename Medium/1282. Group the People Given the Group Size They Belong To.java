class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> group = hm.getOrDefault(groupSizes[i], new ArrayList<>());
            group.add(i);
            if (group.size() == groupSizes[i]) {
                res.add(group);
                hm.remove(groupSizes[i]);
            } else {
                hm.put(groupSizes[i], group);
            }
        }
        return res;
    }
}