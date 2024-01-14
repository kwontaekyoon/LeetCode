class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26], freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == 0 ^ freq2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 25; i > -1; i--) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> charToFreq1 = new HashMap<>();
        Map<Character, Integer> charToFreq2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            charToFreq1.put(c, charToFreq1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            charToFreq2.put(c, charToFreq2.getOrDefault(c, 0) + 1);
        }
        if (!charToFreq1.keySet().equals(charToFreq2.keySet())) {
            return false;
        }
        Map<Integer, Integer> freqToFreq1 = new HashMap<>();
        Map<Integer, Integer> freqToFreq2 = new HashMap<>();
        for (int value : charToFreq1.values()) {
            freqToFreq1.put(value, freqToFreq1.getOrDefault(value, 0) + 1);
        }
        for (int value : charToFreq2.values()) {
            freqToFreq2.put(value, freqToFreq2.getOrDefault(value, 0) + 1);
        }
        return freqToFreq1.equals(freqToFreq2);
    }
}