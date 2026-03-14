class Solution {
    /**
     * Returns the k-th lexicographical happy string of length n.
     * A happy string contains only 'a', 'b', 'c' and no two adjacent chars are
     * equal.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public String getHappyString(int n, int k) {
        if (n <= 0) {
            return "";
        }

        // Total happy strings of length n: 3 * 2^(n-1)
        long total = 3L << (n - 1);
        if (k > total) {
            return "";
        }

        char[] result = new char[n];
        long remainingK = k;

        for (int i = 0; i < n; i++) {
            // Number of strings for each choice at position i
            long blockSize = 1L << (n - i - 1);

            if (i == 0) {
                // First character: choices are 'a', 'b', 'c'
                for (char c : new char[] { 'a', 'b', 'c' }) {
                    if (remainingK > blockSize) {
                        remainingK -= blockSize;
                        continue;
                    }
                    result[i] = c;
                    break;
                }
            } else {
                // Subsequent characters: choose from the two letters != previous
                char prev = result[i - 1];
                for (char c : new char[] { 'a', 'b', 'c' }) {
                    if (c == prev) {
                        continue;
                    }
                    if (remainingK > blockSize) {
                        remainingK -= blockSize;
                        continue;
                    }
                    result[i] = c;
                    break;
                }
            }
        }

        return new String(result);
    }
}