class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int wordSize = words[0].length();
        int windowSize = words.length * wordSize;
        var map = new HashMap<String, Integer>();
        for (var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        var res = new ArrayList<Integer>();
        for (int i = 0; i <= n - windowSize; i++) {
            if (isValid(s.substring(i, i + windowSize), map, wordSize)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isValid(String s, Map map, int wordSize) {
        var tmp = new HashMap<String, Integer>(map);

        for (int i = 0; i < s.length(); i += wordSize) {
            var sub = s.substring(i, i + wordSize);
            int got = tmp.getOrDefault(sub, 0);
            if (got == 0) {
                return false;
            }
            tmp.put(sub, got - 1);
        }
        
        return true;
    }
}