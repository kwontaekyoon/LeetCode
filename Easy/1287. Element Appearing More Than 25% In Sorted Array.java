class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int target = n / 4;
        for (int i = 0; i < n - target; i++) {
            if (arr[i] == arr[i + target]) {
                return arr[i];
            }
        }
        // int idx = 0;
        // int cur = arr[0];
        // int streak = 0;
        // while (idx < n) {
        // if (cur == arr[idx]) {
        // streak += 1;
        // if (streak > target) {
        // return cur;
        // }
        // idx += 1;
        // } else {
        // streak = 1;
        // cur = arr[idx];
        // idx += 1;
        // }
        // }
        return -1;
    }
}