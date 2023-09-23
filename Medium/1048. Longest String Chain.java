class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        Map<String, Integer> hm = new HashMap<>();
        int maxChainSize = 0;
        for (String word : words) {
            int chainSize = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String prevWord = sb.deleteCharAt(i).toString();
                chainSize = Math.max(chainSize, hm.getOrDefault(prevWord, 0) + 1);
            }
            hm.put(word, chainSize);
            maxChainSize = Math.max(maxChainSize, chainSize);
        }
        return maxChainSize;
    }
}