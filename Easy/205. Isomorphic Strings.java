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