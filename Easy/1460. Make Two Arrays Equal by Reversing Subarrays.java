class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        final int n = target.length;
        final var map = new int[1001];
        for (int i = 0; i < n; i++) {
            map[target[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (map[arr[i]] > 0) {
                map[arr[i]]--;
            } else {
                return false;
            }
        }
        return true;
    }
}