class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final var dict = new HashSet<String>(Arrays.asList(words));
        final var res = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (var word : words) {
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }
        for (var word : words) {
            if (isValid(word, dict, min, max)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isValid(String word, Set<String> dict, int min, int max) {
        dict.remove(word);
        final int N = word.length();
        final var dp = new boolean[N + 1];
        dp[0] = true;
        for (int end = min; end <= N; end++) {
            for (int start = end - min; start >= Math.max(0, end - max); start--) {
                if (!dp[start]) {
                    continue;
                }
                if (dict.contains(word.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        dict.add(word);
        return dp[N];
    }
}