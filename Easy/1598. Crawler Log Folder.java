class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (var log : logs) {
            if (log.charAt(1) == '.') {
                level = Math.max(0, level - 1);
            } else if (log.charAt(0) != '.') {
                level++;
            }
        }
        return level;
    }
}