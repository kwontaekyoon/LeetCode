import java.util.Arrays;

class Solution {
    private int countBits(int num) {
        int twos = 1;
        int cnt = 0;
        while (num >= twos) {
            twos *= 2;
        }
        for (int div = twos / 2; div > 0 && num > 0; div /= 2) {
            if (num - div >= 0) {
                num -= div;
                cnt++;
            }
        }
        return cnt;
    }

    public int[] sortByBits(int[] arr) {
        // List<Integer>[] al = new ArrayList[14];
        // for (int num : arr) {
        // int cnt = countBits(num);
        // if (al[cnt] == null) {
        // al[cnt] = new ArrayList<>();
        // }
        // al[cnt].add(num);
        // }
        // for (int i = 0, idx = 0; i < al.length && idx < arr.length; i++) {
        // if (al[i] == null) {
        // continue;
        // }
        // al[i].sort((x, y) -> Integer.compare(x, y));
        // for (int num : al[i]) {
        // arr[idx++] = num;
        // }
        // }
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 11111 * Integer.bitCount(arr[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 11111;
        }
        return arr;
    }
}