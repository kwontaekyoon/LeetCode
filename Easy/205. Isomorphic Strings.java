class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sToChars = s.toCharArray(), tToChars = t.toCharArray();
        Map<Character, Integer> hm1 = new HashMap<>(), hm2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int last1 = hm1.getOrDefault(sToChars[i], -1);
            int last2 = hm2.getOrDefault(tToChars[i], -1);
            if (last1 != last2)
                return false;
            hm1.put(sToChars[i], i);
            hm2.put(tToChars[i], i);

        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        var map = new HashMap<Character, Character>();
        var set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (set.contains(c2)) {
                    return false;
                }
                map.put(c1, c2);
                set.add(c2);
            }
        }
        return true;
    }
}