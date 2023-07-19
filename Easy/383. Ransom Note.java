class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) - 1);
            if (hm.get(c) < 0)
                return false;
        }
        return true;
    }
}