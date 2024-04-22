class Solution {
    public int openLock(String[] deadends, String target) {
        var set = new HashSet<String>(Arrays.asList(deadends));
        var queue = new ArrayDeque<String>();
        queue.offer("0000");
        int changes = 0;
        while (!queue.isEmpty()) {
            for (int q = queue.size(); q > 0; q--) {
                var curr = queue.poll();
                if (curr.equals(target)) {
                    return changes;   
                }
                if (!set.add(curr)) {
                    continue;
                }
                var chars = curr.toCharArray();
                for (int i = 0; i < 4; i++) {
                    chars[i] = chars[i] == '9' ? '0' : (char) (chars[i] + 1);
                    queue.offer(new String(chars));
                    chars[i] = chars[i] == '0' ? '9' : (char) (chars[i] - 1);

                    chars[i] = chars[i] == '0' ? '9' : (char) (chars[i] - 1);
                    queue.offer(new String(chars));
                    chars[i] = chars[i] == '9' ? '0' : (char) (chars[i] + 1);
                }
            }
            changes++;
        }
        return -1;
    }
}