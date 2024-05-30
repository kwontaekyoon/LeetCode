class Solution {
    public int countTriplets(int[] arr) {
        final int N = arr.length;
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            int prefix = arr[i];
            for (int k = i + 1; k < N; k++) {
                prefix ^= arr[k];
                if (prefix == 0) {
                    count += (k - i);
                }
            }
        }
        return count;
    }
}