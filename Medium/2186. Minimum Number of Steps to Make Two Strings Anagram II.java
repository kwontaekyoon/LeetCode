class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) - 1);
        }

        int steps = 0;
        for (int diff : hm.values()) {
            steps += Math.abs(diff);
        }

        return steps;
    }
}