class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freqs = new int[n + 1];
        int[] result = new int[n];
        int common = 0;
        for (int i = 0; i < n; i++) {
            if (++freqs[A[i]] == 2) {
                common++;
            }
            if (++freqs[B[i]] == 2) {
                common++;
            }
            result[i] = common;
        }
        return result;
    }
}

class BruteForce {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            Set<Integer> intersection = new HashSet<>();
            intersection.addAll(setA);
            intersection.retainAll(setB);
            result[i] = intersection.size();
        }
        return result;
    }
}
