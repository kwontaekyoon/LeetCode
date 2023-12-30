class Solution {
    public boolean makeEqual(String[] words) {
        int[] freqs = new int[26];
        int n = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freqs[c - 'a']++;
            }
        }
        for (int freq : freqs) {
            if (freq % n != 0) {
                return false;
            }
        }
        return true;
    }
}