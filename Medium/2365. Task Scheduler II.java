class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long day = 0;
        for (int t : tasks) {
            if (map.get(t) != null) {
                day = Math.max(map.get(t) + space, day);
            }
            map.put(t, ++day);
        }
        return day;
    }
}