class Solution {

    private Set<List<Integer>> hs;

    private void makePerms(int[] nums, int idx, List<Integer> perm) {
        if (perm.size() > 1) {
            hs.add(new ArrayList<>(perm));
        }
        for (int i = idx; i < nums.length; i++) {
            if (perm.isEmpty() || (perm.get(perm.size() - 1) <= nums[i])) {
                perm.add(nums[i]);
                if (!hs.contains(perm)) {
                    makePerms(nums, i + 1, perm);
                }
                perm.remove(perm.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        hs = new HashSet<>();
        makePerms(nums, 0, new ArrayList<>());
        return new ArrayList<>(hs);
    }

}
