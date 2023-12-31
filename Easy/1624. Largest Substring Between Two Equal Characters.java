class Solution {
    // 2D
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] freqs = new int[26][2];
        for (int row[] : freqs) {
            Arrays.fill(row, -1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int slot = chars[i] - 'a';
            if (freqs[slot][0] == -1) {
                freqs[slot][0] = i;
            } else {
                freqs[slot][1] = i;
            }
        }
        int maxLen = -1;
        for (int[] row : freqs) {
            maxLen = Math.max(row[1] - row[0] - 1, maxLen);
        }
        return maxLen;
    }

    // 1D
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        char[] chars = s.toCharArray();
        int maxLen = -1;
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'a';
            if (map[pos] != -1) {
                maxLen = Math.max(i - map[pos] - 1, maxLen);
            } else {
                map[pos] = i;
            }
        }
        return maxLen;
    }
}