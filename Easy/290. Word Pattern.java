class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        if (chars.length != words.length)
            return false;
        for (int i = 0; i < chars.length; i++) {
            hs.add(words[i]);
            if (hm.containsKey(chars[i])) {
                if (!hm.get(chars[i]).equals(words[i]))
                    return false;
            } else {
                hm.put(chars[i], words[i]);
            }
            if (hs.size() != hm.size())
                return false;
        }
        return true;
    }
}