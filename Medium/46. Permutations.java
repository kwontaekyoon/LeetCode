class Solution {
    private List<List<Integer>> perms = new ArrayList<>();

    private void makePerms(int[] nums, boolean[] used, List<Integer> perm) {
        if (perm.size() == nums.length) {
            perms.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm.add(nums[i]);
                    makePerms(nums, used, perm);
                    perm.remove(perm.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        makePerms(nums, new boolean[nums.length], new ArrayList<>());
        return perms;
    }
}