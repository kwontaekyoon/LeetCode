class Solution {
    public int[] findArray(int[] pref) {
        // pref[1] = arr[0] ^ arr[1] -> arr[1] = pref[0] ^ pref[1]
        // pref[2] = arr[0] ^ arr[1] ^ arr[2] -> arr[2] = pref[2] ^ pref[1];
        // pref[3] = arr[0] ^ arr[1] ^ arr[2] ^ arr[3] -> arr[3] = pref[2] ^ pref[3];
        int[] tmp = new int[pref.length];
        tmp[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            tmp[i] = pref[i] ^ pref[i - 1];
        }
        return tmp;
    }
}