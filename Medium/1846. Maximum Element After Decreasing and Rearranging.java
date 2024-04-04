class Sorting {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - 1 > arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[n - 1];
    }
}

class Counting {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        var freq = new int[n + 1];
        for (int i = 0; i < n; i++) {
            freq[Math.min(n, arr[i])]++;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = Math.min(res + freq[i], i);
        }
        return res;
    }
}