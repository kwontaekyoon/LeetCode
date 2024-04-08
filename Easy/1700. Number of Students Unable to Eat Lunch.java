class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n =  sandwiches.length;
        var queue = new ArrayDeque<Integer>();
        for (int s : students) {
            queue.offer(s);
        }
        var changed = true;
        for (int i = 0; i < n && changed; i++) {
            changed = false;
            for (int j = queue.size(); j > 0 && !changed; j--) {
                int cur = queue.poll();
                if (sandwiches[i] == cur) {
                    changed = true;
                } else {
                    queue.offer(cur);
                }
            }
        }
        return queue.size();
    }
}