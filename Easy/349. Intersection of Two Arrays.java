class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums1) {
            hs.add(num);
        }
        List<Integer> al = new ArrayList<>();
        for (int num : nums2) {
            if (hs.remove(num)) {
                al.add(num);
            }
        }
        int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }
}