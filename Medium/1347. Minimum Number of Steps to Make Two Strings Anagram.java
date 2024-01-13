class Solution {
    public int minSteps(String s, String t) {
        int[] alphabetFreqs = new int[26];
        for (char c : s.toCharArray()) {
            alphabetFreqs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphabetFreqs[c - 'a']--;
        }
        int pos = 0, neg = 0;
        for (int freq : alphabetFreqs) {
            if (freq > 0) {
                pos += freq;
            } else {
                neg -= freq;
            }
        }
        return Math.max(pos, neg);
    }
}