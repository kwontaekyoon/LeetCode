class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        Set<Integer> hs = new HashSet<>();
        int cnt = 0;
        for (int freq : hm.values()) {
            while (freq > 0 && hs.contains(freq)) {
                freq--;
                cnt++;
            }
            hs.add(freq);
        }
        return cnt;
    }
}