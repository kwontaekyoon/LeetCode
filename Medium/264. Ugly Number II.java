class Solution {
    public int nthUglyNumber(int n) {
        final var primes = new int[] { 2, 3, 5 };
        final var indice = new int[] { 0, 0, 0 };
        final var uglyArr = new int[n];
        uglyArr[0] = 1;

        for (int i = 1; i < n; i++) {
            final var next = new int[] {
                    uglyArr[indice[0]] * primes[0],
                    uglyArr[indice[1]] * primes[1],
                    uglyArr[indice[2]] * primes[2]
            };
            int minVal = Math.min(next[0], Math.min(next[1], next[2]));
            uglyArr[i] = minVal;
            for (int j = 0; j < 3; j++) {
                if (next[j] == minVal) {
                    indice[j]++;
                }
            }
        }

        return uglyArr[n - 1];
    }
}