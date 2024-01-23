class Solution {
    private int maxLen = 0;
    public int maxLength(List<String> arr) {
        backtrack(arr, "", 0);
        return maxLen;
    }
    private void backtrack(List<String> arr, String cur, int idx) {
        maxLen = Math.max(maxLen, cur.length());
        for (int i = idx; i < arr.size(); i++) {
            if (isValid(cur, arr.get(i))) {
                backtrack(arr, cur + arr.get(i), i + 1);
            }
        }
    }
    private boolean isValid(String cur, String next) {
        char[] freqs = new char[26];
        for (char c : cur.toCharArray()) {
            freqs[c - 'a']++;
            if (freqs[c - 'a'] > 1) {
                return false;
            }
        }
        for (char c : next.toCharArray()) {
            freqs[c - 'a']++;
            if (freqs[c - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    public int bruteForce(List<String> arr) {
        List<Set<Character>> setArr = new ArrayList<>();
        for (String s : arr) {
            Set<Character> hs = new HashSet<>();
            for (char c : s.toCharArray()) {
                hs.add(c);
            }
            if (s.length() == hs.size()) {
                setArr.add(hs);
            } else {
                setArr.add(new HashSet<>());
            }
        }
        List<List<Set<Character>>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(setArr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            Set<Character> cur = setArr.get(i);
            dp.add(new ArrayList<>());
            dp.get(i).add(cur);
            for (Set<Character> prev : dp.get(i - 1)) {
                Set<Character> tmp = new HashSet<>();
                tmp.addAll(cur);
                tmp.addAll(prev);
                if (tmp.size() == prev.size() + cur.size()) {
                    dp.get(i).add(tmp);
                }
            }
            dp.get(i).addAll(dp.get(i - 1));
        }
        int maxLen = 0;
        for (int i = 0; i < dp.size(); i++) {
            for (Set<Character> set : dp.get(i)) {
                maxLen = Math.max(maxLen, set.size());
            }
        }
        return maxLen;
    }
}