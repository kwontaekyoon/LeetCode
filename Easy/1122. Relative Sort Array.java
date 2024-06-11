class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final var cnt = new int[1001];
        for (int num : arr1) {
            cnt[num]++;
        }
        int idx = 0;
        for (int num : arr2) {
            if (cnt[num] == 0) {
                continue;
            }
            for (int i = idx; i < idx + cnt[num]; i++) {
                arr1[i] = num;
            }
            idx += cnt[num];
            cnt[num] = 0;
        }
        for (int num = 0; num <= 1000; num++) {
            if (cnt[num] == 0) {
                continue;
            }
            for (int i = idx; i < idx + cnt[num]; i++) {
                arr1[i] = num;
            }
            idx += cnt[num];
        }
        return arr1;
    }
}